package com.thoughtworks.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class FileLoader {
    public static List<String> loadFile(String fileName) {
        List<String> inputs = new ArrayList<>();
        File file = getFileFromResources(fileName);

        try (FileReader fileReader = new FileReader(file)) {
            BufferedReader br = new BufferedReader(fileReader);

            String line;
            while ((line = br.readLine()) != null) {
                inputs.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return inputs;
    }

    private static File getFileFromResources(String fileName) {
        ClassLoader classLoader = FileLoader.class.getClassLoader();
        URL resource = classLoader.getResource(fileName);

        if (resource == null) {
            throw new IllegalArgumentException("File is not found!");
        } else {
            return new File(resource.getFile());
        }
    }
}
