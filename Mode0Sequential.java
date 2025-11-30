
import java.util.*;

public class Mode0Sequential {
    public void run(SudokuBoard board) {
        List<String> errors = new ArrayList<>();
        for (int r = 0; r < 9; r++) check(board.getRow(r), "ROW " + (r+1), errors);
        for (int c = 0; c < 9; c++) check(board.getColumn(c), "COL " + (c+1), errors);
        for (int b = 0; b < 9; b++) check(board.getBox(b), "BOX " + (b+1), errors);
        print(errors);
    }
    private void check(int[] arr, String label, List<String> e) {
        int[] f = new int[10];
        for (int x : arr) f[x]++;
        for (int i=1;i<=9;i++) if (f[i]>1) e.add(label+", #"+i);
    }
    private void print(List<String> e){
        if(e.isEmpty()) System.out.println("VALID");
        else{
            System.out.println("INVALID");
            for(String s:e) System.out.println(s);
        }
    }
}
