package com.nioproject.network;


import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.SelectionKey;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Collections;
import java.util.Map;
import java.util.Random;


public class RandomStream {
    public static final int PORT_NUMBER = 1027;
    public static final int BUFFER_SIZE = 1024 * 1024;

    final Random rnd = new Random();
    final ByteBuffer buffer = ByteBuffer.allocate(BUFFER_SIZE);
    final byte[] b = new byte[BUFFER_SIZE];
    private Server server;

    public static void main(String[] args) throws IOException {
        new RandomStream().start();
    }

    /**
     * START
     * @throws IOException
     */
    private void start() throws IOException {
        new Thread(() -> {
            try {
                for (int i = 20; i > 0; i--) {
                    Thread.sleep(1000);

                }
            } catch (InterruptedException ignored) {
            }

            server.stop();

        }).start();// Start server
        server = new Server().withPort(PORT_NUMBER).withTimeout(5000).withAcceptHandler(this::acceptConnection);
        server.start();
    }

    private void writeRandomBytes(Channel channel) {
        try {
            SocketChannel socketChannel = (SocketChannel) channel;

            rnd.nextBytes(b);
            buffer.put(b);
            buffer.flip();
            socketChannel.write(buffer);
            buffer.clear();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void acceptConnection(Channel channel) {
        try {

            final ServerSocketChannel socket = (ServerSocketChannel) channel;
            final SocketChannel socketChannel = socket.accept();
            // config socket channel
            socketChannel.configureBlocking(false);
            server.register(socketChannel, SelectionKey.OP_WRITE, Collections.singletonMap(SelectionKey.OP_WRITE, this::writeRandomBytes));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}