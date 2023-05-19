package org.example;

import java.util.Arrays;

public class Board {
    private int size;
    private char[][] table;
    private int winner;

    public Board() {
        this.size = 14;
        this.table = new char[size][size];
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                table[row][col] = ' ';
            }
        }
    }

    public boolean isValidMove(int row, int col) {
        System.out.println(table[row][col]);
        return table[row][col] == ' ';
    }

    public void placePiece(int row, int col, char piece) {
        table[row][col] = piece;
    }
   public boolean isBoardFull() {
       for (int row = 0; row < size; row++) {
           for (int col = 0; col < size; col++) {
               if (table[row][col] == ' ')
                   return false;
           }

       }
       return true;
   }
    public char[][] getGrid() {
        return table;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "Board{" +
                "table=" + Arrays.toString(table) +
                '}';
    }
    public boolean hasWinner()
    {
        char player='a';
        for (int i = 0; i < size; i++) {
            int count = 0;
            for (int j = 0; j < size; j++) {
                if (table[i][j] == player ) {
                    count++;
                    if (count == 5) {
                            this.winner=1;
                        return true;
                    }
                } else {
                    count = 0;
                }
            }
        }
        for (int j = 0; j < size; j++) {
            int count = 0;
            for (int i = 0; i < size; i++) {
                if (table[i][j] == player) {
                    count++;
                    if (count == 5) {
                        winner=2;
                        return true;
                    }
                } else {
                    count = 0;
                }
            }
        }
        player='n';
        for (int i = 0; i < size; i++) {
            int count = 0;
            for (int j = 0; j < size; j++) {
                if (table[i][j] == player ) {
                    count++;
                    if (count == 5) {
                        this.winner=2;
                        return true;
                    }
                } else {
                    count = 0;
                }
            }
        }
        for (int j = 0; j < size; j++) {
            int count = 0;
            for (int i = 0; i < size; i++) {
                if (table[i][j] == player) {
                    count++;
                    if (count == 5) {
                        winner=2;
                        return true;
                    }
                } else {
                    count = 0;
                }
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (checkDiagonal('a', table, i, j, 1, 0, 5) || checkDiagonal('a', table, i, j, 1, 1, 5) ||
                        checkDiagonal('a', table, i, j, 0, 1, 5) || checkDiagonal('a',table, i, j, 1, -1, 5)) {
                    winner=1;
                    return true;
                }
                if (checkDiagonal('n', table, i, j, 1, 0, 5) || checkDiagonal('n', table, i, j, 1, 1, 5) ||
                        checkDiagonal('n',table, i, j, 0, 1, 5) || checkDiagonal('n',table, i, j, 1, -1, 5)) {
                    winner=2;
                    return true;
                }
            }
        }
        return false;
    }
    private static boolean checkDiagonal(char player, char[][] matrix, int row, int col, int rowStep, int colStep, int consecutiveCount) {
        int n = matrix.length;
        int m = matrix[0].length;
        int count = 0;

        while (row >= 0 && row < n && col >= 0 && col < m) {
            if (matrix[row][col] == player) {
                count++;
                if (count == consecutiveCount) {
                    return true;
                }
            } else {
                count = 0;
            }

            row += rowStep;
            col += colStep;
        }

        return false;
    }

    public int getWinner()
    {
        System.out.println(winner);
        return winner;
    }

}
