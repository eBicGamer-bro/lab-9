package org.example;

import org.example.Threads.Threading;
import org.example.Threads.ThreadingFactory;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter The Name of the csv File: ");
        String filename = scanner.nextLine();
        Board board = new Board(filename);
        System.out.print("Enter Type of Treading (0,3,27): ");
        String sType = scanner.nextLine();
        int type = Integer.parseInt(sType);
        Threading threading = ThreadingFactory.create(type,board);
        threading.run();
    }
}