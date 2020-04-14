package com.java.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TcpIpClient {

    public static void main(String[] args) {
        Socket socket = null;
        try {
            socket = new Socket("localhost",7777);

            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            out.println("홍길동");
            String text = in.readLine();
            System.out.println("서버 응답 메세지: " +text);

            out.close();
            in.close();

            socket.close();

        }  catch(IOException e) {e.printStackTrace();}
    }
}
