package com.pipestream;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
public class PipedClient extends Thread {
    PipedInputStream pipeIn;
    PipedOutputStream pipeOut;


    public PipedClient(PipedInputStream pipeIn, PipedOutputStream pipeOut) {
        this.pipeIn = pipeIn;
        this.pipeOut = pipeOut;
    }


    @SuppressWarnings("deprecation")
    public void run() {
        DataInputStream dataIn = new DataInputStream(pipeIn);
        DataOutputStream dataOut = new DataOutputStream(pipeOut);
        try {
            System.out.println("SimplePipedClient: Writing message to the server : ");
            dataOut.writeChars("Message from the SimplePipedClient to the Server\n");
        } catch (IOException ex) {
            System.out.println("SimplePipedClient: IOException : Couldn't get the response from the server.");
            System.exit(1);
        }
        // Server responds
        try {
            System.out.println("SimplePipedClient: Reading response from the server : ");
            String response = dataIn.readUTF();
            System.out.println("SimplePipedClient: Server response : " + response);
        } catch (IOException e) {
            System.out.println("SimplePipedClient: IO Exception : Failed to connect to peer.");
        }

        stop();
    }
}