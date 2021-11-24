package com.dockerforjavadevelopers.hello.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

// TODO: to be moved to proper error handling.

public class ReadFileService {
    String readJasonFile(String path) {
        StringBuilder stringBuilder = new StringBuilder();
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(path);
        } catch (FileNotFoundException e) {
            System.out.println("File doesn't exist.");
            System.exit(1);
        }
        BufferedReader bufferedFileReader = new BufferedReader(fileReader);
        try {
            String startLine = bufferedFileReader.readLine();
            while (startLine != null) {
                stringBuilder.append(startLine);
                startLine = bufferedFileReader.readLine();
            }
        } catch (IOException e) {
            System.out.println("File reading exception.");
            System.exit(2);
        }
        try {
            fileReader.close();
        } catch (IOException e) {
            System.out.println("File closing exception.");
            System.exit(3);
        }
        return stringBuilder.toString();
    }
}
