package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AddCommand extends Command {
    static private Catalog c;
    static private Document d;

    @Override
    public void execute() {
        c.add(d);
        System.out.println("Am executat");
    }

    public AddCommand(Catalog c, Document d) {
        this.c=c;
        if(d.getPath()==null)
        {
            try {
                throw new InvalidDocument();
            } catch (InvalidDocument e) {
                throw new RuntimeException(e);
            }
        }
        this.d=d;
    }
}
