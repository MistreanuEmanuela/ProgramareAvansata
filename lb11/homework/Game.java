package com.example.demo;

import jakarta.persistence.*;

@Entity
@Table(name = "games")
public class Game {
    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne
        @JoinColumn(name = "player1_id")
        private Player player1;

        @ManyToOne
        @JoinColumn(name = "player2_id")
        private Player player2;

        @ManyToOne
        @JoinColumn(name = "winner_id")
        private Player winner;

        @Column(name = "status_end")
        private String statusEnd;


        public Game() {
        }

        public Game(Player player1, Player player2, Player winner, String statusEnd) {
            this.player1 = player1;
            this.player2 = player2;
            this.winner = winner;
            this.statusEnd = statusEnd;
        }



        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Player getPlayer1() {
            return player1;
        }

        public void setPlayer1(Player player1) {
            this.player1 = player1;
        }

        public Player getPlayer2() {
            return player2;
        }

        public void setPlayer2(Player player2) {
            this.player2 = player2;
        }

        public Player getWinner() {
            return winner;
        }

        public void setWinner(Player winner) {
            this.winner = winner;
        }

        public String getStatusEnd() {
            return statusEnd;
        }

        public void setStatusEnd(String statusEnd) {
            this.statusEnd = statusEnd;
        }
    }