package org.example;

public class ToStringCommand extends Command{
    Catalog catalog;
    @Override
    public void execute() {
       System.out.println(catalog.toString());
    }
    ToStringCommand(Catalog c)
    {
        this.catalog=c;
    }
}
