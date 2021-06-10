package com.tasks.date;

import jdk.internal.org.objectweb.asm.TypeReference;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Cast {
    public static void main(String[] args) {

        String str1 = "01.04.2020";
        String str2 = "27.04.2020";
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd.MM.yyyy");
        SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String creationDate = ""; //
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  //
        // Date date= format.parse(str1);  //
        try {



            Date d1 = dateFormat1.parse(str1);
            Date d2 = dateFormat1.parse(str2);

            Date d3 = new Date();

            dateFormat2.applyPattern("yyyy-MM-dd HH:mm:ss");
            String str1New = dateFormat2.format(d1);
            String str2New = dateFormat2.format(d2);

            String str3New = dateFormat2.format(d3);

            Date date1 = dateFormat2.parse(str1New);
            Date date2 = dateFormat2.parse(str2New);

            Date date3 = dateFormat2.parse(str3New);


            System.out.println(date1 + "\n" + date2);
//            System.out.println(d1 + "\n" + d2);
//            System.out.println(date3 + "\n");

            //Date startDate = new Date("1587848400" + "01.01.1970");

        } catch (ParseException e) { e.printStackTrace(); }

    }
}
