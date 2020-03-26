package com.pipestream;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipedServer extends Thread {
    PipedInputStream pipeIn;
    PipedOutputStream pipeOut;

    public PipedServer(PipedInputStream pipeIn, PipedOutputStream pipeOut)
    {
        this.pipeIn = pipeIn;
        this.pipeOut = pipeOut;
    }


    @SuppressWarnings("deprecation")
    public void run()
    {
        // Wrap piped input and output streams with data input and output streams
        DataInputStream dataIn = new DataInputStream(pipeIn);
        DataOutputStream dataOut = new DataOutputStream(pipeOut);
        // Accept the client communication
        try
        {
            System.out.println("SimplePipedServer: Reading message from client : ");

            String clientMessage = dataIn.readUTF();
            System.out.println("SimplePipedServer: Client message: " + clientMessage);
        }
        catch (IOException ex)
        {
            System.out.println("SimplePipedServer: IO Exception : Couldn't read the message from the client.");
            stop();
        }
        try
        {
            System.out.println("SimplePipedServer: Writing response to the client : ");
            dataOut.writeChars("Message from the server.\n");
        }
        catch (IOException ex)
        {
            System.out.println("SimplePipedServer: IO Exception : Failed to connect to client.");
        }
        stop();
    }
}


