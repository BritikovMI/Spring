package ru.rbt.jetski.advanta;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class WriteToFile {
    public static void writeListToFile(List<String> lines){
        Path file = Paths.get("export.txt");
        try {
            Files.write(file, lines, Charset.forName("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeStringToFile(String lines){
        Path file = Paths.get("export.txt");
        try {
            Files.write(file, Arrays.asList(lines), Charset.forName("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
