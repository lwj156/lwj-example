package com.lwj.io.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Linwj
 * @date 2019/8/28 16:00
 */
public class ServerSocketDemo {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket=new ServerSocket(8080);
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
        String a=bufferedReader.readLine();
        while (a!=null){
            System.out.println(a);
            a=bufferedReader.readLine();
        }
        bufferedReader.close();
        socket.close();
        serverSocket.close();
    }
}
