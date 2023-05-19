package org.example;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerService {
        public static String sayHello(String name) {
            return "Greetings from " + name;
        }
    }