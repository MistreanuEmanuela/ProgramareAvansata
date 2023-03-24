package org.example;

import com.github.javafaker.Faker;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        Faker faker=new Faker();
        var students = IntStream.rangeClosed(0, 2)
                .mapToObj(i -> new Student(faker.name().firstName()))
                .toArray(Student[]::new);
        var projects = IntStream.rangeClosed(0, 2)
                .mapToObj(i -> new Project(faker.name().firstName()) )
                .toArray(Project[]::new);

        List<Student> list=new LinkedList<>();
        Collections.addAll(list, students);
        Collections.sort(list);
        System.out.println(list);

        TreeSet<Project> list2=new TreeSet<>();
        Collections.addAll(list2, projects);
        System.out.println(list2);

        Problem problem=new Problem();
        problem.list=list;
        problem.list2=list2;

        problem.addProjectList(list.get(0), Arrays.asList(projects[0], projects[1], projects[2]));
        problem.addProjectList(list.get(1),  Arrays.asList(projects[0], projects[1]));
        problem.addProjectList(list.get(2),  Arrays.asList(projects[0]));

        problem.printStudentsWithFewPref();
        problem.resolve();
    }
}