package ru.rti.gitcloner;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.nio.file.Files;

public class Cloner {
    public static void clone(String filePath) {
        File repos = new File(filePath);
        if (!repos.exists()) {
            System.out.println("File not found");
        } else {
            try {
                for (String line: Files.readAllLines(repos.toPath())) {
                    Runtime runtime = Runtime.getRuntime();
                    String command = "git clone " + line;
                    Process process = runtime.exec(command);
                    BufferedReader inputReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                    BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
                    String s = null;
                    while ((s = inputReader.readLine()) != null) {
                        System.out.println(s);
                    }
                    while ((s = errorReader.readLine()) != null) {
                        System.out.println(s);
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
