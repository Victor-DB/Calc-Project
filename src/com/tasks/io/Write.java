package com.tasks.io;

import sun.jvm.hotspot.oops.OopUtilities;

import java.io.*;

public class Write {
    public static void main(String[] args) {

        // класс наследник всех классов ниже
        OutputStream outputStream = null;

        FileOutputStream fileOutputStream = null;
        FileWriter fileWriter = null;
        String str = "Эту строку запишем в файл";

        // класс для работы с файлами и каталогами на внешних носителях
        File file = new File("/Users/17876577/Documents/WORKPLACE/Java/io/1.txt");

        try {

            // fileOutputStream = new FileOutputStream("/Users/17876577/Documents/WORKPLACE/Java/io/1.txt");
            // перезаписали в файл с заменой содержимого
            // fileOutputStream.write(str.getBytes());

            // запишем в файл добавив новое содержимое с помощоью 2го аргумента append = true :
            fileWriter = new FileWriter(file, true);
            fileWriter.append("\n");
            fileWriter.write(str);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
