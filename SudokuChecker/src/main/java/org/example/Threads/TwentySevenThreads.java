package org.example.Threads;

import org.example.Board;
import org.example.Checkers.Checker;
import org.example.Checkers.CheckerFactory;

public class TwentySevenThreads extends Threading {
    public TwentySevenThreads(Board board) {
        super(board);
    }

    @Override
    public void run() throws InterruptedException {
        Thread[] threads = new Thread[27];
        int index = 0;
        for (int i = 0; i < 9; i++) {
            final int rowIndex = i;
            threads[index++] = new Thread(() -> {
                Checker rowChecker = CheckerFactory.create("row", rowIndex, board);
                rowChecker.Check(error);
            });}
        for (int i = 0; i < 9; i++) {
                final int colIndex = i;
                threads[index++] = new Thread(() -> {
                    Checker colChecker = CheckerFactory.create("col", colIndex, board);
                    colChecker.Check(error);
                });}
        for (int i = 0; i < 9; i++) {
            final int boxIndex = i;
            threads[index++] = new Thread(() -> {
                Checker boxChecker = CheckerFactory.create("box", boxIndex, board);
                boxChecker.Check(error);
            });}

                for (Thread t : threads) {
                    t.start();
                }
                for (Thread t : threads) {
                    t.join();
                }
            print();
            }
        }


