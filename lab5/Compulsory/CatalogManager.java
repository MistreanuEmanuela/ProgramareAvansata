package org.example;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CatalogManager {


    public void addDocument(Catalog catalog, Document doc) {

        catalog.add(doc);
    }

    public void printCatalog(Catalog catalog) {

        System.out.println(catalog.toString());
    }

    public void saveCatalog(Catalog catalog, String fileName) {
        FileWriter file = null;
        try {
            file = new FileWriter(fileName);
        } catch (IOException e) {
            System.out.println("File can not be created");
        }
        try {
           catalog.save(fileName);
        } catch (IOException e) {
            System.out.println("Unexpected error writing the file!");
            e.printStackTrace();
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

    public void loadCatalog(Catalog catalog,String fileName) {
        FileReader file = null;
        try {
            file = new FileReader(fileName);
        } catch (IOException e) {
            System.out.println("File can be opend");
        }
        try {
            catalog.load(fileName);
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
}
