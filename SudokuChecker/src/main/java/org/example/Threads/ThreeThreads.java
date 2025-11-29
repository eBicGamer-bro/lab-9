package org.example.Threads;

import org.example.Board;
import org.example.Checkers.Checker;
import org.example.Checkers.CheckerFactory;

public class ThreeThreads extends Threading {
    public ThreeThreads(Board board) {
        super(board);
    }

    @Override
    public void run() {
        Thread rowThread = new Thread(() -> {
            for (int i = 0; i < 9; i++) {
                Checker rowChecker = CheckerFactory.create("row", i, board);
                rowChecker.Check(error);
            }
        });

        Thread colThread = new Thread(() -> {
            for (int i = 0; i < 9; i++) {
                Checker colChecker = CheckerFactory.create("col", i, board);
                colChecker.Check(error);
            }
        });

        Thread boxThread = new Thread(() -> {
            for (int i = 0; i < 9; i++) {
                Checker boxChecker = CheckerFactory.create("box", i, board);
                boxChecker.Check(error);
            }
        });

        rowThread.start();
        colThread.start();
        boxThread.start();

        try {
            rowThread.join();
            colThread.join();
            boxThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        print();
    }

}
