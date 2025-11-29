package org.example.Checkers;

import org.example.Board;

import java.util.ArrayList;
import java.util.List;

public class ColumnChecker extends Checker {

    public ColumnChecker(Board board, int index) {
        super(board,index);
    }

    @Override
    public void Check(List<String> error) {
        int[][] boards = board.getBoard();
        ArrayList<Integer> num = new ArrayList<>();
        ArrayList<Integer> ind = new ArrayList<>();
        for(int i = 0; i<9 ; i++){
            for (int j = i+1 ; j<9 ; j++){
                if(boards[i][index] == boards[j][index]){
                    if(!num.contains(boards[i][index]))
                        num.add(boards[i][index]);
                    if(!ind.contains(i+1))
                        ind.add(i+1);
                    if(!ind.contains(j+1))
                        ind.add(j+1);
                }
            }
        }
        if(!num.isEmpty()&&!ind.isEmpty())
            error.add(errorAdjust("Column " + (index+1) + ",",num,ind));

    }
    }

