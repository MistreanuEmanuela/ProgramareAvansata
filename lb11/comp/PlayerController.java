package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

@RestController
public class PlayerController {
    @Autowired
    private PlayerService playerService;
    @Autowired
    PlayerList playerList = PlayerList.getInstance();

    private List<Player> players = new ArrayList<>();

    public PlayerController() {

        players.addAll(playerList.getPlayers());
        System.out.println(getPlayers());
        Player p=new Player("Ana");
        players.add(p);
        p.setName("Maria");
        players.add(p);
    }

    @GetMapping("/players")
    public List<Player> getPlayers() {
        return players;
    }
}
