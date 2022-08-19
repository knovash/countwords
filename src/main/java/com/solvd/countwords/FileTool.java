package com.solvd.countwords;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FileTool {

    public static String getString(String fileName) throws IOException {

        File file = new File(fileName);
        String text = FileUtils.readFileToString(file);
        return text;
    }
}
