package com.hansonsoftware.minecraftify;

import java.io.File;
import java.io.FileFilter;

/**
 * Created by djhyb_000 on 9/13/2014.
 */
public class FileIO {
    public static File lastFileModified(String dir) {
        File fileDirectory = new File(dir);
        File[] files = fileDirectory.listFiles(new FileFilter() {
            public boolean accept(File file) {
                return file.isFile();
            }
        });

        long dateOfLastModifiedFile = Long.MIN_VALUE;

        File lastModifiedFile = null;
        for (File file : files) {
            if (file.lastModified() > dateOfLastModifiedFile) {
                lastModifiedFile = file;
                dateOfLastModifiedFile = file.lastModified();
            }
        }
        return lastModifiedFile;
    }
}
