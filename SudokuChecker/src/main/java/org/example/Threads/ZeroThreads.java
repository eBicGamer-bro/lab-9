package org.example.Threads;

import org.example.Board;
import org.example.Checkers.Checker;
import org.example.Checkers.CheckerFactory;

public class ZeroThreads extends Threading {
    public ZeroThreads(Board board) {
        super(board);
    }
    public void run(){
        for(int i = 0;i<9;i++){
            Checker rowChecker = CheckerFactory.create("row",i,board);
            rowChecker.Check(error);
        }
        for(int i = 0;i<9;i++){
            Checker columnChecker = CheckerFactory.create("col",i,board);
            columnChecker.Check(error);
        }
        for(int i = 0;i<9;i++){
            Checker boxChecker = CheckerFactory.create("box",i,board);
            boxChecker.Check(error);
        }
        print();
    }
}
