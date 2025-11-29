package org.example.Threads;

import org.example.Board;

public class ThreadingFactory {
    public static Threading create(int type, Board board){
        switch (type){
                case 0:{
                    return new ZeroThreads(board);
                }
                case 3:{
                    return new ThreeThreads(board);
                }
                case 27:{
                    return new TwentySevenThreads(board);
            }
            default:{
                System.out.println("Invalid Type!");
                System.exit(0);
            }
        }
        return null;
    }
}
