package com.pipestream;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;


public class Main {

    public static void main(String[] args) {
        final PipedOutputStream pipedOut = new PipedOutputStream();

        final PipedInputStream pipedIn = new PipedInputStream(pipedOut);

        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pipedOut.write("Hello world, pipe!".getBytes());
                } catch (IOException e) {
                }
            }
        });


        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    int pipedData = pipedIn.read();
                    while(pipedData != -1){
                        System.out.print((char) pipedData);
                        pipedData = pipedIn.read();
                    }
                } catch (IOException e) {
                }
            }
        });


        threadOne.start();
        threadTwo.start();
    }
}
