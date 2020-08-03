package com.test.lz4;

import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;
import net.jpountz.lz4.LZ4BlockInputStream;
import net.jpountz.lz4.LZ4BlockOutputStream;
import net.jpountz.lz4.LZ4Compressor;
import net.jpountz.lz4.LZ4Factory;
import net.jpountz.lz4.LZ4FastDecompressor;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

public class Lz4CompressTest {

    // 压缩byte数组
    public static byte[] compressLz4(byte[] srcByte) {
        if (srcByte == null) {
            throw new NullPointerException("srcByte cannot be null");
        }
        LZ4Factory lz4Factory = LZ4Factory.fastestInstance();
        LZ4Compressor lz4Compressor = lz4Factory.fastCompressor();
        return lz4Compressor.compress(srcByte);
    }

    // 解压缩数组
    public static byte[] deCompressLz4(byte[] srcByte, int srcLength) {
        if (srcByte == null) {
            throw new NullPointerException("srcByte cannot be null");
        }
        LZ4Factory lz4Factory = LZ4Factory.fastestInstance();
        LZ4FastDecompressor lz4FastDecompressor = lz4Factory.fastDecompressor();
        return lz4FastDecompressor.decompress(srcByte, srcLength);
    }

    // 使用流模式压缩
    public static byte[] compressLz4WithStream(byte[] srcByte) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        LZ4Factory factory = LZ4Factory.fastestInstance();
        LZ4Compressor lz4Compressor = factory.fastCompressor();
        LZ4BlockOutputStream outputStream = new LZ4BlockOutputStream(bos, 64, lz4Compressor);
        outputStream.write(srcByte);
        outputStream.close();// 必须先close,否则不贵不会写入数据
        byte[] bytes = bos.toByteArray();
        System.out.println(bos);
        return bytes;
    }

    // 使用流模式解压缩
    public static byte[] deCompressLz4WithStream(byte[] bytes) throws IOException {
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        LZ4FastDecompressor decompressor = LZ4Factory.fastestInstance().fastDecompressor();
        LZ4BlockInputStream inputStream = new LZ4BlockInputStream(bis, decompressor);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] bs = new byte[2048];
        int read = 0;
        while ( (read = (inputStream.read(bs))) != -1) {
            bos.write(bs, 0, read);
        }
        return bos.toByteArray();
    }

    // 压缩对象
    public static byte[] compressObject(Object object) throws IOException, SecurityException {
        LZ4Compressor lz4Compressor = LZ4Factory.fastestInstance().fastCompressor();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        LZ4BlockOutputStream lz4BlockOutputStream =
                new LZ4BlockOutputStream(bos, 1024, lz4Compressor);
        ObjectOutputStream oos = new ObjectOutputStream(lz4BlockOutputStream);
        oos.writeObject(object);
        oos.close();
        lz4BlockOutputStream.close();
        return bos.toByteArray();
    }

    // 解压对象
    public static <T> T deCompressObject(byte[] bytes) throws IOException, ClassNotFoundException {
        byte[] result = deCompressLz4WithStream(bytes);
        ByteArrayInputStream bis = new ByteArrayInputStream(result);
        ObjectInputStream ois = new ObjectInputStream(bis);
        return (T) ois.readObject();
    }

//    public static void main(String[] args) throws IOException {
//        byte[] param = "wishl gmy 123456".getBytes();
//        byte[] bytes = compressLz4WithStream(param);
//        byte[] result = deCompressLz4WithStream(bytes);
//        System.out.println(new String(result));
//    }

//    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        TestModel testModel = new TestModel();
//        testModel.setAge(18);
//        testModel.setName("gmy");
//        ByteArrayOutputStream bos = new ByteArrayOutputStream();
//        ObjectOutputStream oos = new ObjectOutputStream(bos);
//        oos.writeObject(testModel);
//        byte[] bytes = compressObject(testModel);
//        System.out.println(Arrays.toString(bos.toByteArray()));
//        System.out.println(Arrays.toString(bytes));
//        Object object = deCompressObject(bytes);
//        System.out.println(object);
//        long objectSize = ObjectAgent.getObjectSize(object);
//        System.out.println(objectSize);
//    }

    public static void main(String[] args) throws IOException {
        Map<String, Boolean> map = new HashMap<>();
        String keyPrefix = "hag_test_";
        for (int i = 0; i < 2000000; i++) {
            map.put(keyPrefix + i, true);
        }
        // 214M
        System.out.println(ObjectSizeCalculator.getObjectSize(map));
        System.out.println(ObjectSizeCalculator.getObjectSize(new Integer(1234)));
        byte[] bytes = compressObject(map);
        // 13M
        System.out.println(ObjectSizeCalculator.getObjectSize(bytes));
    }

}
