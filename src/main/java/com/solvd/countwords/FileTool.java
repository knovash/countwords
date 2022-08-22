package com.solvd.countwords;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class FileTool {

    public static String getString(String fileName) throws IOException {
        File file = new File(fileName);
        String text = FileUtils.readFileToString(file);
        return text;
    }

    public static void putList(String fileName, List<String> text) throws IOException {
        File file = new File(fileName);
        FileUtils.writeLines(file, text);
    }
}
