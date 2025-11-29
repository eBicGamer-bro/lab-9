package org.example.Checkers;

import org.example.Board;

public class CheckerFactory {
    public static Checker create(String type, int index, Board board) {
        switch(type) {
            case "row": {
                return new RowChecker(board, index);
            }
            case "col": {
                return new ColumnChecker(board, index);
            }
            case "box": {
                return new BoxChecker(board, index);
            }
            default: {
                System.out.println("Invalid Type!");
                System.exit(0);
            }
        }
        return null;
    }
}
