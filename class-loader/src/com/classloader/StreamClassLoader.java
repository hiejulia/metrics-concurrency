package com.classloader;


import java.io.IOException;
import java.io.InputStream;
import java.util.Hashtable;

public abstract class StreamClassLoader extends ClassLoader {

    Hashtable<String, Class<?>> componentCache = new Hashtable<String, Class<?>>();

    InputStream source = null;

    public StreamClassLoader() {
    }


    protected abstract String parseComponentNaming(String componentLocation) throws ClassNotFoundException;

    protected abstract void initializeStream(String componentLocation) throws IOException;

    protected abstract Class<?> readComponent(String componentLocation, String componentName) throws IOException, ClassNotFoundException;

    // Load component
    public Class<?> loadComponent(String componentLocation, boolean resolve) throws ClassNotFoundException {

        // Parse
        String componentName = parseComponentNaming(componentLocation);
        Class<?> component = (Class<?>) componentCache.get(componentName);
        if (component == null) {
            try {
                // stream
                initializeStream(componentLocation);
            } catch (IOException e) {
                throw new ClassNotFoundException("Failed opening stream to URL.");
            }
            try {
                // Read compinet
                component = readComponent(componentLocation, componentName);
            } catch (IOException e) {
                throw new ClassNotFoundException("Failed reading class component from the stream: " + e);
            }
        }
        // cache
        componentCache.put(componentName, component);
        if (resolve)
            resolveClass(component);
        return component;
    }
}