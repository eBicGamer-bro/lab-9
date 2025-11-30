
public class SudokuBoard {
    private int[][] board;

    public SudokuBoard(int[][] board) {
        this.board = board;
    }

    public int get(int r, int c) {
        return board[r][c];
    }

    public int[] getRow(int r) {
        return board[r];
    }

    public int[] getColumn(int c) {
        int[] col = new int[9];
        for (int i = 0; i < 9; i++) col[i] = board[i][c];
        return col;
    }

    public int[] getBox(int boxIndex) {
        int[] b = new int[9];
        int startRow = (boxIndex / 3) * 3;
        int startCol = (boxIndex % 3) * 3;
        int k = 0;
        for (int r = startRow; r < startRow + 3; r++)
            for (int c = startCol; c < startCol + 3; c++)
                b[k++] = board[r][c];
        return b;
    }
}
