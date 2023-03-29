package org.example;

import javax.print.Doc;
import java.io.File;
import java.io.IOException;

import java.awt.Desktop;

public class ViewCommand extends Command {
    private Document doc;
    @Override
    public void execute() {
        File file = new File(doc.getPath());
        Desktop desktop = Desktop.getDesktop();
        try {
            desktop.open(file);
        } catch (IOException ioe) {
            System.out.println("error");
        }
    }


    ViewCommand(Document d) {
        this.doc = d;
    }
}