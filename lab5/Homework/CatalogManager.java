package org.example;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CatalogManager {
    public void execute (Command c)  {
        try{
            c.execute();
            if(c==null)
                throw new InvalidCommand();
        } catch (InvalidCommand e) {
            throw new RuntimeException(e);
        }

    }

    public CatalogManager() {
    }
    public void printCatalog(Catalog catalog) {

        System.out.println(catalog.toString());
    }
}
