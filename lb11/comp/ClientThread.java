package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import static java.lang.System.out;
@Component
class ClientThread extends Thread {
    private Socket socket = null ;
    private GameServer server; // Reference to the server instance
    private Player player;
    private Game game;
   private PlayerList playerList=PlayerList.getInstance();

    public void printBoard(PrintWriter out, Board board, Game game)
    {
        if(game.isEnd()==true)
        {
            out.println("Jocul acesta s-a terminat, timpul a expirat");
            out.flush();
        }
        char[][] table = board.getGrid();
        int size = board.getSize();
        out.println("Board:");
        for (int row = 0; row < size; row++) {
            if(row==0) {
                out.print("   ");
                for (int col = 0; col < size; col++) {
                    out.print(String.format("%2d ", col));
                }
                out.println();
            }
            out.print(String.format("%2d ", row));
            for (int col = 0; col < size; col++) {

                if(table[row][col] != ' ')
                {
                    out.print(" "+ table[row][col]+ " ");
                }
                else
                {
                    out.print(" "+ "o"+ " ");
                }
            }
            out.println();
        }

        out.println("EndOfResponse");
        out.flush();
    }
    public ClientThread(){}
    public void handleMakeMove(PrintWriter out, Board board, Game game,BufferedReader in) throws IOException {
        if(game.isEnd()==false) {
            String request;
            long startTime = System.currentTimeMillis();
            out.println("Enter the line:");
            out.println("EndOfResponse");
            out.flush();
            request = in.readLine();
            int line = Integer.parseInt(request);
            out.println("Enter the column:");
            out.println("EndOfResponse");
            out.flush();
            request = in.readLine();
            long endTime = System.currentTimeMillis();
            long timeTaken = endTime - startTime;
            player.setTime(timeTaken);
            if (player.getTime() < 0) {
                out.println("Jocul a luat sfarsit-timpul a expirat");
                out.println("EndOfResponse");
                game.setEnd(true);
                out.flush();
            } else {
                int column = Integer.parseInt(request);
                System.out.println(column + " " + line);
                Move move = new Move(line, column, player);
                game.makeMove(move);
                if (game.isGameOver()) {
                    if (game.getBoard().hasWinner()) {
                        out.println(game.getWinner() + "a castigat");
                        out.println("EndOfResponse");
                    } else {
                        out.println("egalitatea");
                        out.println("EndOfResponse");
                    }
                }
                printBoard(out, game.getBoard(), game);
            }
        }
        else {
            printBoard(out, game.getBoard(), game);
        }
    }
    public ClientThread(Socket socket, GameServer server) {
        this.socket = socket;
        this.server = server;

    }
    public void run () {
        try {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            String request;
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            while ((request = in.readLine()) != null) {
                if (request.equals("stop")) {
                    out.println("Server stopped");
                    System.out.println("Server stopped");
                    out.println("EndOfResponse");
                    out.flush();
                    System.exit(-1);
                }
                else {
                    if (request.equals("new game")) {
                        this.player=new Player('a');
                        game = server.createGame(player);
                        server.getPlayers().add(player);
                        playerList.setPlayers(player);
                        System.out.println(playerList.getPlayers());
                        out.println("New game created with ID: " + game.getGameId());
                        out.flush();
                        int i=0;
                        while (game.avaible()) {
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                            printBoard(out,game.getBoard(),game);
                    }
                     else {
                        if( request.equals("make a move")) {
                            if(game.getCurrentPlayer()!=player && game.isEnd()==false)
                            {
                                out.println("Waiting for the other move");
                                out.flush();
                            }
                            while (game.getCurrentPlayer()!=player && game.isEnd()==false) {
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                           handleMakeMove(out,game.getBoard(),game,in);
                        }
                         else{
                            if( request.equals("participate")) {
                                for(int i=1; i<=server.getGames().size(); i++)
                                {
                                    if(server.getGame(i).avaible())
                                    {
                                        System.out.println("Da");
                                        this.player=new Player('n');
                                        server.getPlayers().add(player);
                                        this.game=server.getGame(i);
                                        server.getGame(i).setPlayer2(player);
                                        printBoard(out,game.getBoard(),game);
                                        break;
                                    }
                                }
                                out.flush();
                            }
                           else{
                                out.println("invalid command");
                                out.println("EndOfResponse");
                                out.flush();
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Communication error... " + e);
        } finally {
            try {
                socket.close();
            } catch (IOException e) { System.err.println (e); }
        }
    }
}