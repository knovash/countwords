package com.solvd.countwords;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

public class Utils {

    public static String getText(String fileName) throws IOException {
        URL resource = Main.class.getClassLoader().getResource(fileName);
        File file = new File(resource.getFile());
        return FileUtils.readFileToString(file);
    }

    public static void outText(String fileName, List<String> text) throws IOException {
        File file = new File(fileName);
        FileUtils.writeLines(file, text);
    }
}
