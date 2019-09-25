package com.lwj.io.bio;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * @author Linwj
 * @date 2019/8/28 16:23
 */
public class ClientSocketDemo {
    public static void main(String[] args) throws IOException {

        Socket socket=new Socket("localhost",8080);
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("123");
        bufferedWriter.close();
        outputStream.close();
        socket.close();
    }
}
