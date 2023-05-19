package org.example;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Resources {
    public static void main(String[] args) throws IOException {
        SpringApplication.run(Resources.class, args);
        System.out.println("Hello world!");
        GameServer server;
        server = new GameServer();
    }}

