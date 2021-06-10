package com.tasks.string;

public class StringEquals {

    //Сравнение строк
    public static String compareMinString(String a, String b) {
        char[] aChar = a.toCharArray();
        char[] bChar = b.toCharArray();

        String min = "";
        int len = Math.min(aChar.length, bChar.length);
        for(int i = 0; i < len; i++) {
            if (aChar[i] == bChar[i]) {
                if (i < len - 1) {
                    continue;
                }
            } else if (aChar[i] < bChar[i]) {
                min = b;
            } else {
                min = a;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println("Сравнение строк: " + compareMinString("asdw", "asdf"));
    }
}


