package com.udp;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Main {

    public static void main(String[] args) {
	// write your code here


        // Test 1

        for (int i = 0; i < 5; i++) {
            byte[] buff = new byte[256];
            pkt = new DatagramPacket(buff, buff.length);
            soc.receive(pkt);
            String rcvdString = new String(pkt.getData());
            System.out.println("Quote: " + rcvdString);
        }

        MulticastSocket soc = new MulticastSocket(1400);
        InetAddress grp = InetAddress.getByName("172.0.114.0");
        soc.joinGroup(group);


        soc.leaveGroup(group);
        soc.close();

    }
}
