package com.java.net;

import java.net.*;
import java.io.*;
public class UdpClient {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket();

        byte[] data = "홍길동".getBytes();
        DatagramPacket packet = new DatagramPacket(data,data.length,new InetSocketAddress("localhost",9999));
        datagramSocket.send(packet);

        datagramSocket.close();
    }
}
