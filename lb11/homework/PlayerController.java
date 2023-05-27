package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
@CrossOrigin(origins = "http://localhost:8082")
public class PlayerController {

    @Autowired
    private PlayerService playersService;
    @GetMapping
    public ResponseEntity<List<Player>> getAllPlayers() {
        List<Player> players = playersService.getAllPlayers();
        return new ResponseEntity<>(players, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Player> addPlayer(@RequestParam String playerName) {
        Player player = playersService.addPlayer(playerName);
        return new ResponseEntity<>(player, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Player> updatePlayerName(@PathVariable Long id, @RequestParam String playerName) {
        Player player = playersService.updatePlayerName(id, playerName);
        return new ResponseEntity<>(player, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePlayer(@PathVariable Long id) {
        playersService.deletePlayer(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}