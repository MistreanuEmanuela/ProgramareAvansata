package org.example;

import javax.swing.text.View;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Document d=new Document("Ion");
        Catalog c=new Catalog();
        d.addTag("autor", "Vasile");
        d.setId("5");
        d.setPath("C:/Users/My Pc/Desktop/file.json");
        Document Cerere=new Document("Cerere");
        Cerere.setId("7");
        Cerere.addTag("autor", "Mircea Eliade");
        CatalogManager m=new CatalogManager();
        AddCommand add=new AddCommand(c,d);
        m.execute(add);
        AddCommand add1=new AddCommand(c,Cerere);
        Cerere.setPath("C:/Users/My Pc/Desktop/file.json");
        m.execute(add1);
        LoadCommand load=new LoadCommand("C:/Users/My Pc/Desktop/file.json");
        m.execute(load);
        m.execute(new AddCommand(c,d));
        SaveCommand save=new SaveCommand(c,"C:/Users/My Pc/Desktop/file.json");
        ToStringCommand str=new ToStringCommand(c);
        m.execute(str);
        ListCommand r=new ListCommand(c);
        m.execute(r);
        ViewCommand v=new ViewCommand(d);
         m.execute(v);
        ReportCommand rc=new ReportCommand(c);
        m.execute(rc);
        Catalog G= new Catalog();
        ReportCommand rap=new ReportCommand(G);
         m.execute(rap);

    }
}