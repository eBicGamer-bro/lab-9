package org.example.Checkers;

import org.example.Board;

import java.util.ArrayList;
import java.util.List;

public class RowChecker extends Checker {
    public RowChecker(Board board, int index) {
        super(board,index);
    }


    @Override
    public void Check(List<String> error) {
        int[][] boards = board.getBoard();
        ArrayList<Integer> num = new ArrayList<>();
        ArrayList<Integer> ind = new ArrayList<>();
        for(int i = 0; i<9 ; i++){
            for (int j = i+1 ; j<9 ; j++){
               if(boards[index][i] == boards[index][j]){
                   if(!num.contains(boards[index][i]))
                       num.add(boards[index][i]);
                   if(!ind.contains(i+1))
                       ind.add(i+1);
                   if(!ind.contains(j+1))
                       ind.add(j+1);
               }
            }
        }
        if(!num.isEmpty()&&!ind.isEmpty())
            error.add(errorAdjust("Row " + (index+1) + ",",num,ind));

    }


}
