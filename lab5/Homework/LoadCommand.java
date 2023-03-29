package org.example;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;

public class LoadCommand extends Command{
    private String filePath;
    @Override
    public void execute() {
        FileReader file = null;
        try {
            file = new FileReader(filePath);
        } catch (IOException e) {
            System.out.println("File can not be opened");
        }
        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader(filePath));
            JSONObject jsonObject = (JSONObject)obj;
            String doc = (String)jsonObject.get("Document");
            System.out.println("Documente: " + doc);
        } catch (IOException e) {
            System.out.println("Unexpected error reading the file!");
            e.printStackTrace();
        } catch (org.json.simple.parser.ParseException i) {
            System.out.println("Unexpected error reading the file!");
            i.printStackTrace();
        }  finally {
            try {
                file.close();
            } catch (FileNotFoundException f) {
                System.out.println("File not found");
            } catch (IOException r) {
                System.out.println("Unexpected error closing the file");
            }
        }
    }

    public LoadCommand(String filePath) {
        this.filePath=filePath;
    }
}
