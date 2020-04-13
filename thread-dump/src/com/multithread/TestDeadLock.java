//package com.multithread;
//
//import java.io.IOException;
//
//public class TestDeadLock {
//    public static void main(String[] args) throws IOException {
//
//        System.out.println("Type any character and Enter to cause deadlock - ");
//                System.in.read();
//
//        final Object obj1 = new Object(), obj2 = new Object();
//
//        Thread th1 = new Thread("MyThread1") {
//            public void run() {
//                synchronized (obj1) {
//                    try {
//                        sleep(2000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//
//                    synchronized (obj2) {
//                        //do nothing
//                    }
//                }
//            }
//        };
//
//        Thread th2 = new Thread("MyThread2") {
//            public void run() {
//                synchronized (obj2) {
//                    try {
//                        sleep(2000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//
//                    synchronized (obj1) {
//
//                    }
//                }
//            }
//        };
//
//
//        th1.start();
//        th2.start();
//
//}
//
//}
