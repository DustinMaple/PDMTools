package com.maple.pdm.utils;

import java.io.*;

/**
 * The utility for operate file.
 * Created by gjf on 2016/10/19.
 */
public class FileUtil {

    /**
     * Write a string to a file.
     *
     * @param file
     * @param str
     * @throws IOException
     */
    public static void appendToFile(File file, String str) {
        try (
                FileWriter writer = new FileWriter(file, true);
        ) {
            writer.append(str);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Clear all old content of a file.
     *
     * @param file
     */
    public static void clearFile(File file) {
        try (
                FileWriter writer = new FileWriter(file)
        ) {
            writer.write("");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Initialize the file.
     *
     * @param file
     * @throws IOException
     */
    public static void initFile(File file) {
        try {
            if (!file.exists()) {
                file.createNewFile();
            } else {
                clearFile(file);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
