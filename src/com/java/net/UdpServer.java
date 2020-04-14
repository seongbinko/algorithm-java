package com.java.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpServer {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(9999);

        DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);
        datagramSocket.receive(packet);

        String data = new String(packet.getData(),0,packet.getLength(),"UTF-8");
        System.out.println("수신받은 데이터:" +data);

        datagramSocket.close();
    }

}
