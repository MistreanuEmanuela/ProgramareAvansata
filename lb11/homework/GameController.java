package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8082")
@RequestMapping("/games")
public class GameController {
    @Autowired
    private GameService gameService;
    @RequestMapping
    public List<Game> displayGames() {
        return gameService.displayGames();
    }
}

