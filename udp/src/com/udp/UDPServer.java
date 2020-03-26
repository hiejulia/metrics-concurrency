package com.udp;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPServer {
    public static void main(String args[]) {
        DatagramSocket dgSocket = null;
        if (args.length <= 0) {
            System.out.println("Please pass the port number for UDPServer");
            // exit the program if no port number passed
            System.exit(1);
        }
        try {
            int socketNumber = Integer.valueOf(args[0]).intValue();
            dgSocket = new DatagramSocket(socketNumber);
            byte[] byteBuffer = new byte[1000];
            while (true) {
                DatagramPacket dgRequest = new DatagramPacket(byteBuffer, byteBuffer.length);
                dgSocket.receive(dgRequest);
                DatagramPacket dgresponse = new DatagramPacket(dgRequest.getData(), dgRequest.getLength(),
                        dgRequest.getAddress(), dgRequest.getPort());
                dgSocket.send(dgresponse);
            }
        } catch (SocketException e) {
            System.out.println("Socket Exception : " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO Exception : " + e.getMessage());
        } finally {
            if (dgSocket != null)
                dgSocket.close();
        }
    }
}