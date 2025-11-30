
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter CSV file path: ");
            String filePath = sc.nextLine();
            System.out.print("Enter mode (0,3,27): ");
            int mode = Integer.parseInt(sc.nextLine());

            FileHandler handler = FileHandlerFactory.createHandler("csv");
            SudokuBoard board = handler.load(filePath);

            if (mode == 0) {
                new Mode0Sequential().run(board);
            } else if (mode == 3) {
                new Mode3Parallel().run(board);
            } else if (mode == 27) {
                new Mode27Parallel().run(board);
            } else {
                System.out.println("Invalid mode. Use 0, 3, or 27.");
            }
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
