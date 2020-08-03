package com.test.agent.attach;

import com.test.agent.annon.MethodTiming;
import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.CtNewMethod;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class MyTransformer implements ClassFileTransformer {

    private String model;

    final static String prefix = "\nlong startTime = System.currentTimeMillis();\n";
    final static String postfix = "\nlong endTime = System.currentTimeMillis();\n";

    final static List<String> list = new ArrayList<>();

    final static Map<String, List<String>> methodMap = new HashMap<>();

    public MyTransformer(String model) {
        this.model = model;
    }

    @Override
    public int hashCode() {
        return Objects.hash(model);
    }

    private void add(String methodString) {
        String className = methodString.substring(0, methodString.lastIndexOf("."));
        String methodName = methodString.substring(methodString.lastIndexOf(".") + 1);
        List<String> list = methodMap.get(className);
        if (list == null)
        {
            list = new ArrayList<>();
            methodMap.put(className, list);
        }
        list.add(methodName);
    }

    /**
     * loader - 定义要转换的类加载器；如果是引导加载器，则为 null
     * className - 完全限定类内部形式的类名称和 The Java Virtual Machine Specification 中定义的接口名称。例如，"java/util/List"。
     * classBeingRedefined - 如果是被重定义或重转换触发，则为重定义或重转换的类；如果是类加载，则为 null
     * protectionDomain - 要定义或重定义的类的保护域
     * classfileBuffer - 类文件格式的输入字节缓冲区（不得修改）
     * @return
     * @throws IllegalClassFormatException
     */
    @Override
    public byte[] transform(ClassLoader loader, String className,
                            Class<?> classBeingRedefined, ProtectionDomain protectionDomain,
                            byte[] classfileBuffer) throws IllegalClassFormatException {
        if (className == null) {// 内部类和匿名内部类获取不到className
            return null;
        }
        try {
            String classPath = className.replace("/", ".");
            CtClass ctClass;
            if (classPath.contains(model)) {
                ctClass = ClassPool.getDefault().get(classPath);// 使用全称,用于取得字节码类<使用javassist>
                CtMethod[] methods = ctClass.getMethods();
                for (CtMethod method : methods) {
                    String methodName = method.getName();
                    Object annotation = method.getAnnotation(MethodTiming.class);
                    String outputStr = "\nSystem.out.println(\"this method " + methodName
                            + " cost:\" +(endTime - startTime) +\"ms.\");";
                    try {
                        CtMethod ctmethod = ctClass.getDeclaredMethod(methodName);// 得到这方法实例
                        String newMethodName = methodName + "$old";// 新定义一个方法叫做比如sayHello$old
                        System.out.println(newMethodName);
                        if (annotation == null) {
                            CtMethod newMethod = CtNewMethod.copy(ctmethod, methodName, ctClass, null);
                            ctClass.addMethod(newMethod);
                            continue;
                        }
                        ctmethod.setName(newMethodName);// 将原来的方法名字修改
                        // 创建新的方法，复制原来的方法，名字为原来的名字
                        CtMethod newMethod = CtNewMethod.copy(ctmethod, methodName, ctClass, null);
                        // 构建新的方法体
                        buildMethod(newMethodName, outputStr, newMethod, ctClass);
                    } catch (Exception e) {
                    }
                }
                byte[] bytes = ctClass.toBytecode();
                ctClass.writeFile("/Users/guanmengyuan01/Desktop");
                return bytes;
            }
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("className:" + className);
        }
        return null;
    }

    // 创建新的方法，复制原来的方法，名字为原来的名字
    private void buildMethod(String newMethodName, String outputStr, CtMethod newMethod, CtClass ctClass)
            throws CannotCompileException {
        StringBuilder bodyStr = new StringBuilder();
        bodyStr.append("{");
        bodyStr.append(prefix);
        bodyStr.append("Object object = " + newMethodName + "($$);\n");// 调用原有代码，类似于method();($$)表示所有的参数
        bodyStr.append(postfix);
        bodyStr.append(outputStr);
        bodyStr.append("return ($r) object;\n");
        bodyStr.append("}");
        newMethod.setBody(bodyStr.toString());// 替换新方法
        ctClass.addMethod(newMethod);// 增加新方法
    }


}
