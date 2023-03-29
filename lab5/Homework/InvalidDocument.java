package org.example;

public class InvalidDocument extends Exception{
    public InvalidDocument() {
        super("This doc doesn't have a path");
    }
}
