package org.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class GameServer {
    public static final int PORT = 8100;
    private int nextGameId = 1;
    private Map<Integer, Game> games = new HashMap<>();
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

}
