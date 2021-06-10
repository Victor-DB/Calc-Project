package com.tasks.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

//Будем считывать объекты из файла
public class DeSerialization {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("people.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);

            Person person1 = (Person) ois.readObject();
            Person person2 = (Person) ois.readObject();

            System.out.println(person1);
            System.out.println(person2);
            ois.close();
        } catch (ClassNotFoundException e) { e.printStackTrace();
        } catch (IOException e) { e.printStackTrace(); }
    }
}
