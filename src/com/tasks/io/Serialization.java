package com.tasks.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

//Будем записывать объекты в файл
public class Serialization {
    public static void main(String[] args) {
        Person person1 = new Person(1,"Ведамир");
        Person person2 = new Person(2, "Славодар");

        try {
            FileOutputStream fos = new FileOutputStream("people.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(person1);
            oos.writeObject(person2);

            oos.close();
        } catch (IOException e) { e.printStackTrace(); }
    }
}
