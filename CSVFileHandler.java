
import java.io.BufferedReader;
import java.io.FileReader;

public class CSVFileHandler extends FileHandler {
    @Override
    public SudokuBoard load(String path) throws Exception {
        int[][] board = new int[9][9];
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line;
        int row = 0;
        while ((line = br.readLine()) != null && row < 9) {
            String[] nums = line.split(",");
            for (int col = 0; col < 9; col++) {
                board[row][col] = Integer.parseInt(nums[col].trim());
            }
            row++;
        }
        br.close();
        return new SudokuBoard(board);
    }
}
