package org.example;
import org.json.simple.JSONObject;

import java.io.*;

public class SaveCommand extends  Command{
    private Catalog catalog;
    private String filePath;
    @Override
    public void execute() {
        FileWriter file = null;
        try {
            file = new FileWriter(filePath);
        } catch (IOException e) {
            System.out.println("Unexpected error creating the file!");
        }
        try{
            var obj = new JSONObject();
            obj.put("Document", (catalog.getDoc().toString()));
            file.write(obj.toJSONString());
            file.flush();
        } catch (IOException e) {
            System.out.println("File can not be created");
        } catch (RuntimeException r) {
            System.out.println("Unexpected error writing the file!");
        } finally {
            try {
                file.flush();
                file.close();
            } catch (FileNotFoundException f) {
                System.out.println("File not found");
            } catch (IOException r) {
                System.out.println("Unexpected error closing the file");
            }
        }
    }

    SaveCommand(Catalog catalog, String filePath) {
        this.catalog = catalog;
        this.filePath=filePath;
    }
}

