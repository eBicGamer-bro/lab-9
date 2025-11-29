package org.example;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CSVFileHandler {
    public static int[][] getBoard(String filename){
        int[][] board = new int[9][9];
    try {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        for(int i = 0; i < 9 ; i++){
            line = reader.readLine();
            if(line == null) {
                throw new IOException("File has less than 9 rows");
            }
            String[] parts = line.split(",");
            if(parts.length != 9){
                throw new IOException("Invalid row format");
            }
            for(int j = 0; j<9 ; j++)
                board[i][j] = Integer.parseInt(parts[j]);
            }
        reader.close();
    } catch (FileNotFoundException e){
        System.out.println("Could not find FILE: " + filename);
        System.exit(0);
    } catch (IOException e){
        System.exit(0);
    }

        return board;
    }
}
