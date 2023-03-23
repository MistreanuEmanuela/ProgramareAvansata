package org.example;

import java.util.ArrayList;
import java.util.*;
public class Student implements Comparable <Student> {
    private String name;
    public Student(String s) {
        this.name=s;
    }

    @Override
    public int compareTo(Student o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }

}