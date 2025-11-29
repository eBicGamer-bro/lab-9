package org.example;

public class Board {
    private int[][] board;
    public Board(String filename){
        board = CSVFileHandler.getBoard(filename);
    }

    public int[][] getBoard() {
        return board;
    }
}
