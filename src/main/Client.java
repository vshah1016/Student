package main;

import java.util.Scanner;

public class Client {
    Scanner scanner = new Scanner(System.in);
    private int runAgain = 0;

    public String gatherInput() {
        String input = scanner.nextLine();
        System.out.println();
        return input;
    }

    public boolean isRunAgain() {
        return !(runAgain == 0);
    }

    public int runAgain() {
        System.out.println("0. exit");
        System.out.println("1. Add Person");
        System.out.println("2. Remove Person");
        System.out.println("3. Print all People");
        System.out.println("4. Print all Students");
        System.out.println("5. Print all Undergraduates");
        System.out.println("6. Print all Graduates");
        System.out.println("7. Match Undergraduate Grade");
        System.out.println("8. Match Graduate Major");
        runAgain = scanner.nextInt();
        if (runAgain > 8 || runAgain < 0) {
            runAgain = 0;
            System.out.println("Invalid, exiting.");
        }
        System.out.println();
        scanner.nextLine();
        return runAgain;
    }
}