package com.tasks.io;

import java.io.*;

public class Read {
    public static void main(String[] args) {

        // Потомки абстрактного класса InputStream
        FileInputStream fis = null;
        InputStreamReader isr = null;
        int b = 0;

        try {

            // байтовый поток new FileInputStream (не воспринимает русскую кодировку)
            // символный поток
             fis = new FileInputStream("/Users/17876577/Documents/WORKPLACE/Java/io/1.txt");
             isr = new InputStreamReader(fis, "UTF-8");

                // read возвращает 1 байт из файла
                // в b записываем наши байты заодно
                while ((b = isr.read()) != -1) {
                    System.out.println((char) b);
                }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // отдельный try чтобы каждый поток закрылся если вдруг сработает исключение
            try {
                fis.close();
            } catch (IOException e) { e.printStackTrace(); }
            try {
                isr.close();
            } catch (IOException e) { e.printStackTrace(); }
        }
    }
}
