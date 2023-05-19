package org.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



public class GameServer {
    public static final int PORT = 8100;
    private int nextGameId = 1;
    private Map<Integer, Game> games = new HashMap<>();
    private List<Player> players=new ArrayList<>();

    public Game createGame(Player player1) {
        Game game = new Game(nextGameId, player1);
        games.put(nextGameId, game);
        nextGameId++;
        return game;

    }

    public Game getGame(int gameId) {
        return games.get(gameId);
    }

    public Map<Integer, Game> getGames() {
        return games;
    }

    public GameServer() throws IOException {

        ServerSocket serverSocket = null ;
        try {
            serverSocket = new ServerSocket(PORT);
            while (true) {
                System.out.println ("Waiting for a client ...");
                Socket socket = serverSocket.accept();
                new ClientThread(socket, this).start();
            }
        } catch (IOException e) {
            System.err. println ("Ooops... " + e);
        } finally {
            serverSocket.close();
        }
    }

    public List<Player> getPlayers() {
        return players;
    }
}
