package ru.rti.gitcloner;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("File path: ");
        String filePath = scanner.nextLine();
        Cloner.clone(filePath);
    }
}
