package org.example;

import java.util.ArrayList;
import java.util.List;

public class Project implements Comparable<Project> {
    private String name;
    public Project(String p) {
        this.name = p;
    }

    @Override
    public int compareTo(Project o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                '}';
    }
}
