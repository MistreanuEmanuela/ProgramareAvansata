package org.example;

public class ListCommand extends Command {
    Catalog catalog;
    @Override
    public void execute() {
        System.out.println(catalog.getDoc().toString());
    }

    ListCommand(Catalog c)
    {
        this.catalog=c;
    }
}
