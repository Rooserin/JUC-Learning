package com.cityblue.common.util;


import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

@Slf4j(topic = "cityblue.FileReader")
public class FileReader {

    public static void read(String path) {
        int index = path.lastIndexOf(File.separator);
        String fileName = path.substring(index + 1);
        try (FileInputStream in = new FileInputStream(path)) {
            long start = System.currentTimeMillis();
            log.debug("start reading[{}]", fileName);
            byte[] bytes = new byte[1024];
            int n = -1;
            do {
                in.read(bytes);
            } while (n != -1);
            long end = System.currentTimeMillis();
            log.debug("reading[{}] finished in {}ms", fileName, end - start);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
