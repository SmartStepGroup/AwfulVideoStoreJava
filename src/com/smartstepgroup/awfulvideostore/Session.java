package com.smartstepgroup.awfulvideostore;

import java.io.*;

public class Session {
    private static String fileName = "session.txt";

    public static void add(String key, String value) throws IOException {
        createIfNeeded();
        if (hasKey(key)) {
            return;
        }
        PrintWriter writer = new PrintWriter(fileName, "UTF-8");
        writer.println(key + "=" + value);
        writer.close();
    }

    private static void createIfNeeded() throws IOException {
        File f = new File(fileName);
        if (!f.exists()) {
            f.createNewFile();
        }
    }

    public static boolean hasKey(String loggedUser) throws IOException {
        String sessionContent = readFile();
        return sessionContent.contains(loggedUser);
    }

    public static boolean hasValue(String key, String value) throws IOException {
        String content = readFile();
        return content.contains(key + "=" + value);
    }

    private static String readFile() throws IOException {
        File file = new File(fileName);
        FileInputStream fis = new FileInputStream(file);
        byte[] data = new byte[(int)file.length()];
        fis.read(data);
        fis.close();
        return new String(data, "UTF-8");
    }
}
