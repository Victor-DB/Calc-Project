package com.tasks.date;

import com.sun.javafx.tools.packager.PackagerException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateCompare {

    static Date StringParseToData(String dateString) {
        List<String> formatStrings = Arrays.asList("yyyy-MM-dd", "yyyy.MM.dd");

        for (String formatString : formatStrings) {
            try {
                return new SimpleDateFormat(formatString).parse(dateString);
            } catch (ParseException e) { System.out.println("Обработано исключение ошибки формата строки для даты"); }
        }
        return null;
    }

    public static void main(String[] args) throws ParseException {

        Date date1 = StringParseToData("2015.04.30");
        int num1 = 1;

        Date date2 = StringParseToData("2016-03-08");
        int num2 = 2;

        System.out.println("date1: " + date1);
        System.out.println("date2: " + date2);
        System.out.println(date1.after(date2));

        String dt = new SimpleDateFormat("dd.MM.yyyy").format(new Date());
        System.out.println("2: " + new SimpleDateFormat("dd.MM.yyyy").format(new Date()));

        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy.MM.dd").parse("2020.04.30");
        } catch (ParseException e) { e.printStackTrace(); }
        System.out.println("date: " + date);
    }
}
