package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {
    @Autowired
    GameRepository gamesRepository;
        public List<Game> displayGames() {
            return gamesRepository.findAll();
    }
}
