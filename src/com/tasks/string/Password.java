package com.tasks.string;

/**
 *  Find all combination of password.
 *  Is known that password consists of 6 symbols.
 *  First 2 symbols is "tv", last 6th is "1".
 *  3th, 4th, 5th is shuffle of "2mt"
 */
public class Password {
    public static void main(String[] args) {
        String s1 = "t";
        String s2 = "v";
        String[] s3 = {"2", "m", "t"};
        String[] s4 = {"2", "m", "t"};
        String[] s5 = {"2", "m", "t"};
        String s6 = "1";

        String str ="";
        for (int c = 0; c < s3.length; c++) {
            for (int d = 0; d < s4.length; d++) {
                for (int e = 0; e < s5.length; e++) {
                    str = str +  s1 + s2 + s3[c] + s4[d] + s5[e] + s6;
                    if (str.length() == 6) {
                        System.out.println(str);
                        str = "";
                    }
                }
            }
        }
    }
}

