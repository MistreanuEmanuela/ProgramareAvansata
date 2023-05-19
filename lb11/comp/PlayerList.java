package org.example;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;
@Component
@SessionScope
public class PlayerList {
    List<Player> players=new ArrayList<>();
    private static PlayerList instance;

    @PostConstruct
    private void init() {
        Player c = new Player('c');
        players.add(c);
    }

    public static PlayerList getInstance() {
        if (instance == null) {
            instance = new PlayerList();
        }
        return instance;
    }

    public void setPlayers(Player player) {
        this.players.add(player);
    }

    public List<Player> getPlayers() {
        return players;
    }


}