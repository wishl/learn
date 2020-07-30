package com.test.lz4.kryo;

import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.test.lz4.model.TestModel;
import net.jpountz.lz4.LZ4BlockInputStream;
import net.jpountz.lz4.LZ4BlockOutputStream;
import net.jpountz.lz4.LZ4Compressor;
import net.jpountz.lz4.LZ4Factory;
import net.jpountz.lz4.LZ4FastDecompressor;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * 压缩并序列化
 */
public class SerializeCommon {

    public static  <T> byte[] serialize(T t) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        LZ4Compressor lz4Compressor = LZ4Factory.fastestInstance().fastCompressor();
        LZ4BlockOutputStream lz4Out = new LZ4BlockOutputStream(bos, 2048, lz4Compressor);
        Output output = new Output(lz4Out);
        KryoCommon.writeObject(output, t);
        return bos.toByteArray();
    }

    public static  <T> T deSerialize(byte[] bytes, Class<T> clazz) {
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        LZ4FastDecompressor decompressor = LZ4Factory.fastestInstance().fastDecompressor();
        LZ4BlockInputStream lz4In = new LZ4BlockInputStream(bis, decompressor);
        Input input = new Input(lz4In);
        T result = KryoCommon.readObject(input, clazz);
        return result;
    }

    public static void main(String[] args) {
        TestModel testModel = TestModel.createTestModel();
        byte[] serialize = serialize(testModel);
        TestModel result = deSerialize(serialize, TestModel.class);
        System.out.println(result);
    }

}
