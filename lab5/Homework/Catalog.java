package org.example;
import org.json.simple.JSONObject;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.parser.*;

public class Catalog {
    private List<Document> doc = new ArrayList<>();

    public void add(Document document) {
        this.doc.add(document);
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "doc=" + doc +
                '}';
    }

    public List<Document> getDoc() {
        return doc;
    }

    public void load(String fileName) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader(fileName));
        JSONObject jsonObject = (JSONObject)obj;
        String doc = (String)jsonObject.get("Document");
        System.out.println("Documente: " + doc);
    }

}
