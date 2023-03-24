package org.example;

import java.util.HashMap;
import java.util.Map;

public class Document {

    private String id;
    private String name;
    private String path;
    private Map<String, String> tags = new HashMap<>();
    public void addTag(String key, String value) {
        tags.put(key, value);
    }

    public void setId(String id) {
        this.id = id;
    }

    public Document(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPath(String path) {
        this.path = path;
    }


    @Override
    public String toString() {
        return "Document{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", tags=" + tags +
                '}';
    }
}