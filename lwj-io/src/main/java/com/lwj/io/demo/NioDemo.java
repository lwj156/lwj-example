package com.lwj.io.demo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author Linwj
 * @date 2019/8/26 11:03
 */
public class NioDemo {
    public static void main(String[] args) throws IOException {

        FileInputStream fileInputStream = new FileInputStream("D://LWJ//index.html");
        FileChannel fc = fileInputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(8);
        fc.read(byteBuffer);

        System.out.println(byteBuffer.position());

        byteBuffer.flip();
        while (byteBuffer.remaining() > 0) {
            byte f = byteBuffer.get();
            System.out.println(f);
        }
        byteBuffer.clear();
        fc.close();
    }
}
