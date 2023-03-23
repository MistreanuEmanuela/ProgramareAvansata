package org.example;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;
import java.util.*;
import java.util.stream.Collectors;

public class Problem {
    static List<Student> list = new LinkedList<>();
    static TreeSet<Project> list2 = new TreeSet<>();
    static Map<Student, List<Project>> prefMap = new HashMap<>();

    public static void addProjectList(Student s, List projectList) {
        prefMap.put(s, projectList);
    }

    public static Integer nrPref(Student s) {
        return (prefMap.get(s).size());
    }

    public static double getMedia() {
        double d = list.stream()
                .mapToDouble(s -> nrPref(s))
                .average().getAsDouble();
        return d;
    }

    public static void sort() {
        Collections.sort(list, new Comparator<Student>() {
            public int compare(Student s1, Student s2) {
                return nrPref(s1).compareTo(nrPref(s2));
            }
        });
    }

    public static void printStudentsWithFewPref() {
        System.out.print("Studentii cu putine preferinte sunt: ");
        List<Student> result = list.stream()
                .filter(s -> nrPref(s) < getMedia())
                .collect(Collectors.toList());
        System.out.println(result);
    }

    static Map<Student, Project> atrMap = new HashMap<>();

    public static void algorithmGreedy() {
        sort();
        System.out.print("Urmatoarea atribuire ar fi cea mai eficienta ");
        for (int i = 0; i < list.size(); i++) {
            int amGasitPotrivire = 0;
            int j = 0;
            while (amGasitPotrivire == 0 && j < prefMap.get(list.get(i)).size()) {
                if (!atrMap.containsValue(prefMap.get(list.get(i)).get(j))) {
                    atrMap.put(list.get(i), prefMap.get(list.get(i)).get(j));
                    amGasitPotrivire = 1;
                }
                j++;
            }

        }
        System.out.println(atrMap);
    }

    public static void resolve()
    {
        algorithmGreedy();
    }
}

