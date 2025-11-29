package org.example.Checkers;

import org.example.Board;

import java.util.ArrayList;
import java.util.List;

public class BoxChecker extends Checker {
    public BoxChecker(Board board, int index) {
        super(board,index);
    }

    @Override
    public void Check(List<String> error) {
        int[][] boards = board.getBoard();

        int startRow = (index / 3) * 3;
        int startCol = (index % 3) * 3;

        int[] boxArray = new int[9];
        for (int i = 0; i < 9; i++) {
            int row = startRow + i / 3;
            int col = startCol + i % 3;
            boxArray[i] = boards[row][col];
        }

        ArrayList<Integer> num = new ArrayList<>();
        ArrayList<Integer> ind = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (boxArray[i] == boxArray[j]) {
                    if (!num.contains(boxArray[i]))
                        num.add(boxArray[i]);
                    if (!ind.contains(i+1))
                        ind.add(i+1);
                    if (!ind.contains(j+1))
                        ind.add(j+1);
                }
            }
        }

        if (!num.isEmpty() && !ind.isEmpty())
            error.add(errorAdjust("Box " + (index+1) + ",", num, ind));
    }
}
