**jvm监控**  
1.ASM字节码技术
在JVM加载class二进制文件的时候，利用ASM动态的修改加载的class文件，在监控的方法前后添加计时器功能，  
用于计算监控方法耗时，同时将方法耗时及内部调用情况放入处理器，处理器利用栈先进后出的特点对方法调用先后顺序做处理，  
当一个请求处理结束后，将耗时方法轨迹和入参map输出到文件中，然后根据map中相应参数或耗时方法轨迹中的关键代码区分出我们要抓取的耗时业务。  
2.javassist  
在实际中使用javassist方法更加容易。类实现了ClassFileTransformer接口，并在类加载之前调用transform方法。通过字符串在原类中添加方法或方法处理，并转化为class文件，  
从而实现class类的包装。  
参考资料：  
https://blog.csdn.net/qq_24267619/article/details/105985796
