package com.classloader;


import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLClassLoader extends StreamClassLoader {

    URL urlClass = null;
    InputStream streamClass = null;

    @Override
    protected String parseComponentNaming(String componentLocation) throws ClassNotFoundException {

        String componentName = null;
        try {
            urlClass = new URL(componentLocation);
        } catch (MalformedURLException e) {
            throw new ClassNotFoundException("Bad URL " + componentLocation + " given: " + e);
        }

        String filenameFromURL = urlClass.getFile();

        if (!filenameFromURL.endsWith(".class"))
            throw new ClassNotFoundException("Non-class URL given.");
        else
            componentName = filenameFromURL.substring(0, filenameFromURL.lastIndexOf(".class"));
        System.out.println("Classname = " + componentName);
        return componentName;

    }


    @Override
    protected void initializeStream(String componentLocation) throws IOException {
        streamClass = urlClass.openStream();
    }


    // Read component
    @Override
    protected Class<?> readComponent(String componentLocation, String componentName)
            throws IOException, ClassNotFoundException {
        URLConnection urlConn = urlClass.openConnection();
        int componentSize = urlConn.getContentLength();
        System.out.println("Class file is " + componentSize + " bytes.");
        // data
        DataInputStream dataInClass = new DataInputStream(streamClass);
        int isAvailable = dataInClass.available();
        System.out.println("Available = " + isAvailable);
        System.out.println("URLClassLoader: Reading class from stream...");
        byte[] clsData = new byte[componentSize];
        dataInClass.readFully(clsData);
        Class<?> component = null;
        System.out.println("URLClassLoader: Defining class...");
        try {
            component = defineClass(null,clsData, 0, clsData.length);
        } catch (ClassFormatError e) {
            throw new ClassNotFoundException("Format error found in class data.");
        }
        return component;
    }
}
