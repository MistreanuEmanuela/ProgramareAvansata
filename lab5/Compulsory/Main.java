package org.example;

public class Main {
    public static void main(String[] args) {
        Document d=new Document("Ion");
        Catalog c=new Catalog();
        CatalogManager m=new CatalogManager();
        d.addTag("autor", "Vasile");
        d.setId("5");
        Document Cerere=new Document("Cerere");
        Cerere.setId("7");
        Cerere.addTag("autor", "Mircea Eliade");
        m.addDocument(c, d);
        m.addDocument(c, Cerere);
        m.printCatalog(c);
        m.saveCatalog(c,"C:/Users/My Pc/Desktop/file.json");
        m.loadCatalog(c,"C:/Users/My Pc/Desktop/file.json");
    }
}