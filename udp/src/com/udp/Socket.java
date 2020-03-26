package com.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Socket {

    DatagramSocket udpSock = new DatagramSocket(3000);
    int portNo = udpSock.getLocalPort();


    byte[] dataBuff = {'a', 'k', ' ', 'v', 'w', 'x', 'p', 'e'};
    InetAddress inetAddr = InetAddress.getByName("www.google.com");
    DatagramPacket dgPkt = new DatagramPacket(dataBuff, dataBuff.length, inetAddr, 5100);
    udpSock.send(dgPkt);


}
