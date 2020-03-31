package com.nioproject.niodemo;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;



public class Client {

    public static void main(String[] args) throws IOException, InterruptedException {

        try (SocketChannel socketChannel = SocketChannel.open()) {
            socketChannel.connect(new InetSocketAddress("localhost", RandomStreamServer.PORT_NUMBER));
            ByteBuffer buffer = ByteBuffer.allocate(RandomStreamServer.BUFFER_SIZE);
            int i = 1;
            for (; ; ) {
                socketChannel.read(buffer);
                buffer.flip();
                byte[] bytes = new byte[buffer.limit()];
                buffer.get(bytes);

                buffer.clear();
                Thread.sleep(1000);
            }
        }
    }
}