package org.example;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class MyClassLoader extends URLClassLoader {
    public MyClassLoader(String classFilePath) throws MalformedURLException {
        super(new URL[]{new File(classFilePath).toURI().toURL()}, ClassLoader.getSystemClassLoader());
    }
}