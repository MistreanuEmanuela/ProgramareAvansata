package org.example;

import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        var students = IntStream.rangeClosed(0, 2)
                .mapToObj(i -> new Student("S" + i) )
                .toArray(Student[]::new);
        var projects = IntStream.rangeClosed(0, 2)
                .mapToObj(i -> new Project("P" + i) )
                .toArray(Project[]::new);

        List<Student> list=new LinkedList<>();
        Collections.addAll(list, students);
        Collections.sort(list);
        System.out.println(list);

       TreeSet<Project> list2=new TreeSet<>();
       Collections.addAll(list2, projects);
        System.out.println(list2);

    }
}