package com.java.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TcpIpServer {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(7777);
            System.out.println(getTime() + "서버가 준비되었습니다");
        } catch (IOException e) {e.printStackTrace();}

            try {
                System.out.println(getTime() + "연결 요청을 기다립니다.");
                // 서버소켓은 연결 요청이 올 때까지 실행을 멈추고 계속 기다린다.
                // 클라이언트 연결요청이 오면 클라이언트 소켓과 통신할 새로운 소켓을 생성한다.
                Socket socket = serverSocket.accept();
                System.out.println(getTime() + socket.getInetAddress() + "로부터 요청이 들어왔습니다");

                BufferedReader in =  new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(),true);

                String name = in.readLine();
                out.println(name + "님 반갑습니다");
                in.close();
                out.close();

                socket.close();
                serverSocket.close();


            } catch (IOException e) {e.printStackTrace();}



    }
    static String getTime() {
        SimpleDateFormat format = new SimpleDateFormat("[hh:mm:ss]");
        return format.format(new Date());
    }
}
