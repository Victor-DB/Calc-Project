package com.tasks.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Exercise {


    //17.9 Напишите метод, который получает в качестве параметра два числа (А и В) и выводит на экран все четные числа из диапазона А ... В.
    public static void sumOfNumb(int a, int b) {
        if (a <= b) {
            for (int i = a; i < b; i++) {
               if (i % 2 == 0) {
                   System.out.print(i + " ");
               }
            }
        } else {
            for (int i = b; i < a; i++) {
                if (i % 2 == 0) {
                    System.out.print(i + " ");
                }
            }
        }
    }


    //19.22 Напишите метод, который принимает два параметра: массив целых чисел М и еще одно целое число Х.
    // Метод возвращает количество ячеек массива М, содержащих значение Х (число появлений Х в М).
    public static int amountOfCell(int[] array, int x) {
        for (int i = 0; i < 30; i++) {
            Random random = new Random();
            int j = random.nextInt(10);
            array[i] = j;
        }
        int count = 0;
        for (int j : array) {
            if(j == x) {
                count++;
            }
        }
        return count;
    }


    //21.13 Напишите метод, который получает в качестве параметра строку и воз­вращает строку,
    // составленную только из заглавных букв русского алфавита.
    // Например, для строки АБвrде123ЖзИ метод возвратит АБЖИ.
    public static String editString(String s) {
        String result = "";
        Boolean flag;
        for(int i = 0; i < s.length(); i++){
            String arrStr  = s.substring(i, i + 1);
            flag = arrStr.matches("[А-Я]");
            if(flag == true) {
                result += arrStr;
            }
        }
        return result;
    }

    //21.22 Напишите метод, который принимает в качестве параметра строковое значение и проверяет,
    // состоит ли оно из не повторяющихся ни разу символов.
    public static void checkStr(String string) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < string.length(); i++) {
            String s = string.substring(i, i + 1);

            if(!map.containsKey(s)) {
                map.put(s, 1);
            } else {
               // map.replace(s, map.get(s) + 1);
                System.out.println("Обнаружен повторяющийся символ");
                return;
            }
        }
        System.out.println("Повторяющихся символов не обнаружено");
    }


    public static void cycle(int n) {
        for (int i = 0; i < n; i++) {
            if (i == 1) break;
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        sumOfNumb(3, 25);

        int[] array = new int[30];
        System.out.println("\n" + amountOfCell(array, 5));

        System.out.println(editString("АБвrде123ЖзИ"));

        checkStr("футбол");

        cycle(3);
    }
}

