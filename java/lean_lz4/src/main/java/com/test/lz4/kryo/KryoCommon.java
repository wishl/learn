package com.test.lz4.kryo;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.pool.KryoPool;
import com.test.lz4.model.TestModel;
import org.objenesis.strategy.StdInstantiatorStrategy;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class KryoCommon {

    private static KryoPool pool = new KryoPool.Builder(() -> {
        Kryo kryo = new Kryo();
        kryo.setInstantiatorStrategy(new Kryo.DefaultInstantiatorStrategy(// 首先调用DefaultInstantiatorStrategy
                // 如果失败则调用StdInstantiatorStrategy
                new StdInstantiatorStrategy()
        ));
        kryo.setReferences(false);
        return kryo;
        // 使用软引用，在gc的时候如果内存不够被回收
    }).softReferences().build();


    public static <T> T readObject(Input input, Class<T> clazz) {
        T result = pool.run(kryo -> {
            T t = kryo.readObject(input, clazz);
            return t;
        });
        return result;
    }

    public static <T> void writeObject(Output output, T t) {
        pool.run(kryo -> {
            kryo.writeObject(output, t);
            output.close();
            return null;
        });
    }

    public static <T> T readObject(byte[] bytes, Class<T> clazz) {
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        Input input = new Input(bis);
        T result = readObject(input, clazz);
        return result;
    }

    public static <T> byte[] writeObject(T t) {
        // outPut.close 时已经关闭了内部的io所以不用在关闭一次
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        Output output = new Output(bos);
        writeObject(output, t);
        return bos.toByteArray();
    }


   public static void main(String[] args) {
        TestModel testModel = new TestModel();
        testModel.setName("gmy");
        testModel.setAge(18);
        byte[] bytes = writeObject(testModel);
        TestModel result = readObject(bytes, TestModel.class);
        System.out.println(result);
   }

}
