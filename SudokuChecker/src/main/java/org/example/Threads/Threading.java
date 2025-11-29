package org.example.Threads;

import org.example.Board;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Threading{
    protected List<String> error = Collections.synchronizedList(new ArrayList<>());
    Board board;

    public Threading(Board board) {
        this.board = board;
    }

    public void print(){
    if(error.isEmpty())
        System.out.printf("Valid");
    else{
        System.out.println("Invalid\n");
        for(int i = 0; i<error.size();i++)
            System.out.println(error.get(i));
    }
}
    public abstract void run() throws InterruptedException;
}
