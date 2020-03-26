package com.udp;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPClient {
    public static void main(String args[]){
        // pass the message, server host and port number as arguments
        DatagramSocket dgSocket = null;
        if (args.length < 3) {
            System.out.println(
                    " Pass the arguments for SimpleUDPClient in the order : test message, Server Host name and Port number respectively");
            System.exit(1);
        }
        try {
            dgSocket = new DatagramSocket();
            byte [] bytes = args[0].getBytes();
            InetAddress serverHost = InetAddress.getByName(args[1]);
            int serverPortNumber = Integer.valueOf(args[2]).intValue();
            DatagramPacket dgRequest =
                    new DatagramPacket(bytes, args[0].length(), serverHost, serverPortNumber);
            dgSocket.send(dgRequest);
            byte[] byteBuffer = new byte[1000];
            DatagramPacket dgResponse = new DatagramPacket(byteBuffer, byteBuffer.length);
            dgSocket.receive(dgResponse);
            System.out.println("Datagram Response: " + new String(dgResponse.getData()));
        }
        catch (SocketException e) {
            System.out.println("Socket Exception: " + e.getMessage());
        }
        catch (IOException e) {
            System.out.println("IO Exception : " + e.getMessage());
        }
        finally {
            if (dgSocket != null)
                dgSocket.close();
        }
    }
}