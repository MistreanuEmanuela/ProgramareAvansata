package org.example;
import org.testng.annotations.Test;

import java.lang.reflect.*;
import java.net.URL;


public class Main {
    public static void main(String[] args) {

        try {
            String classFilePath = "C:\\E\\FACULTATE\\2.2\\JAVA\\lab12\\Test\\Main\\target\\classes\\";
            MyClassLoader myLoader = new MyClassLoader(classFilePath);
            Class<?> loadedClass = myLoader.loadClass("org.example.MyProgram");

            System.out.println("Class name: " + loadedClass.getName());
            Package classPackage = loadedClass.getPackage();
            String packageName = classPackage != null ? classPackage.getName() : "(default package)";
            System.out.println("Package: " + packageName);

            // Get methods and invoke static methods annotated with @Test
            Method[] methods = loadedClass.getDeclaredMethods();
            int passed = 0, failed = 0;
            for (Method method : methods) {
                System.out.println("Method: " + method.getName());
                int modifiers = method.getModifiers();
                System.out.println("Modifiers: " + Modifier.toString(modifiers));
                if (method.isAnnotationPresent(Test.class)) {
                    try {
                        method.invoke(null);
                        passed++;
                    } catch (Throwable ex) {
                        System.out.printf("Test %s failed: %s %n",
                                method, ex.getCause());
                        failed++;
                    }
                }
            }
            System.out.printf("Passed: %d, Failed %d%n", passed, failed);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}