package org.example.Checkers;

import org.example.Board;

import java.util.ArrayList;
import java.util.List;

public abstract class Checker {
    protected Board board;
    protected int index;

    public Checker(Board board, int index) {
        this.board = board;
        this.index = index;
    }

    public abstract void Check(List<String> error);
    protected String errorAdjust(String label, ArrayList<Integer> num, ArrayList<Integer> index){
        String repeated = " #";
        String repeatedIndx = " [";
        for (Integer value : num) {
            repeated += value + ",";
        }
        for (Integer integer : index) {
            repeatedIndx += integer + ",";
        }
        repeatedIndx = repeatedIndx.substring(0,repeatedIndx.length()-1);
        repeatedIndx += "]";
        return  label + repeated + repeatedIndx;
    }
}

