package org.example;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private char piece;
    private String name="name"+piece;
    private List<Move> moves;
    private long time=10000;

    public Player( char piece) {
        this.piece = piece;
        this.moves = new ArrayList<>();
    }
    public char getPiece() {
        return piece;
    }

    public void addMoves(Move move) {
        this.moves.add(move);
    }

    public List<Move> getMoves() {
        return moves;
    }

    @Override
    public String toString() {
        return "Player{" +
                "piece=" + piece +
                '}';
    }

    public void setTime(long time) {
        this.time = this.time-time;
    }

    public long getTime() {
        return time;
    }

    public String getName() {
        return name;
    }

   public Player(String name)
   {
       this.name=name;
   }

    public void setName(String name) {
        this.name = name;
    }
}

