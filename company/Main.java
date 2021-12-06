package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        ArrayList<String> data = fileIntoArray("src/com/company/Donnees.csv");
        readXLines(validOption(1, data.size()-1), data);
    }

    public static ArrayList<String> fileIntoArray(String filename) throws IOException {
        BufferedReader file = new BufferedReader(new FileReader(filename));
        ArrayList<String> list = new ArrayList<>();
        String line;
        while ((line = file.readLine()) != null) {
            list.add(line);
        }
        
        return list;
    }

    public static void readXLines(int x, ArrayList<String> data) {
        if (x == 1) {
            System.out.println("Voici la première ligne du fichier:\n");
        } else {
            System.out.printf("Voici les %s premières lignes du fichier:\n\n", x);
        }
        for (int i = 1; i <= x; i++) {
            System.out.printf("Ligne %s:\n    ", i);
            System.out.println(data.get(i) + "\n");
        }
    }

    public static int validOption(int lowestOption, int highestOption) {
        boolean validOptionEntered = false;
        String badInputMessage = "Enter a valid input : ";

        ArrayList<Integer> intList = new ArrayList<>();
        for (int i = lowestOption; i <= highestOption; i++) {
            intList.add(i);
        }

        int option = lowestOption - 1;
        do {
            if (scanner.hasNextInt()) {
                option = scanner.nextInt();

                if (intList.contains(option)) {
                    validOptionEntered = true;
                } else {
                    System.out.print(badInputMessage);
                }

            } else {
                scanner.next();
                System.out.print(badInputMessage);
            }
        } while(!validOptionEntered);

        return option;
    }
}
