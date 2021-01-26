package dev.whydn.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProcessFile {
    public static ProcessFile createProcessFile() {
        return new ProcessFile();
    }

    public List<String> parseFile(String directory, String fileName){
        List<String> result = new ArrayList<>();
        try (BufferedReader buffer = new BufferedReader(new FileReader(directory + fileName))) {
            while (true) {
                String line = buffer.readLine();
                if(line == null) break;
                result.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

}
