package org.example;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private int gameId;
    private Player player1;
    private Player player2;
    private Board board;
    private Player currentPlayer;
    private long startTime;
    private boolean end;

    public boolean isEnd() {
        return end;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setEnd(boolean end) {
        this.end = end;
    }

    public Game(int gameId, Player player1) {
        this.gameId = gameId;
        this.player1 = player1;
        this.board = new Board();
        this.currentPlayer = player1;
        this.startTime = System.currentTimeMillis();
    }

    public void switchPlayer() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public boolean makeMove(Move move) {
        System.out.println(currentPlayer);
        if (currentPlayer == move.getPlayer()) {
            System.out.println("bun");
            if (board.isValidMove(move.getRow(), move.getCol())) {
                System.out.println("si mai bun");
                board.placePiece(move.getRow(), move.getCol(), move.getPlayer().getPiece());
                currentPlayer.getMoves().add(move);
                switchPlayer();
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    public boolean avaible()
    {
        if (this.player2==null)
            return true;
        return false;
    }

    public boolean isGameOver() {
        if (board.hasWinner()) {
            return true;
        }
        if (board.isBoardFull()) {
            return true;
        }
        return false;
    }

    public Player getWinner() {
        if (board.getWinner()==1)
        return player1;
        return player2;
    }
    public long getElapsedTime() {
        return System.currentTimeMillis() - startTime;
    }

    public int getGameId() {
       return this.gameId;
    }
    public Board getBoard()
    {
        return this.board;
    }
}
