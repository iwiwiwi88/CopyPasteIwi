package pl.iwi.copypaste.model.utils;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.URL;

public class FileChanges {

    public static void replaceFileContent(URL uri, String newContent) {
        PrintWriter prw = null;
        try {
            prw = new PrintWriter(uri.getFile());
            prw.println(newContent);
            prw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
