
import java.util.*;

public class Mode27Parallel {
    public void run(SudokuBoard board) throws InterruptedException {
        List<String> errors = Collections.synchronizedList(new ArrayList<>());
        List<Thread> threads = new ArrayList<>();

        for (int r=0;r<9;r++){
            final int i=r;
            threads.add(new Thread(() ->
                check(board.getRow(i), "ROW "+(i+1), errors)
            ));
        }
        for (int c=0;c<9;c++){
            final int i=c;
            threads.add(new Thread(() ->
                check(board.getColumn(i), "COL "+(i+1), errors)
            ));
        }
        for (int b=0;b<9;b++){
            final int i=b;
            threads.add(new Thread(() ->
                check(board.getBox(i), "BOX "+(i+1), errors)
            ));
        }

        for(Thread t:threads) t.start();
        for(Thread t:threads) t.join();

        print(errors);
    }
    private void check(int[] arr, String label, List<String> e){
        int[] f=new int[10];
        for(int x:arr) f[x]++;
        for(int i=1;i<=9;i++) if(f[i]>1) e.add(label+", #"+i);
    }
    private void print(List<String> e){
        if(e.isEmpty()) System.out.println("VALID");
        else{
            System.out.println("INVALID");
            for(String s:e) System.out.println(s);
        }
    }
}
