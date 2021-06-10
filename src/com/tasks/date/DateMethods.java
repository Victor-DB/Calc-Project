package com.tasks.date;

import java.text.SimpleDateFormat;

public class DateMethods {
    public static void main(String[] args) {
        System.out.println("Сгенерировать значение из текущего времени: " + getValuefromCurrentTime());
        System.out.println("Получить текущее время в милисекундах: " + getTimeInMils());

    }

    // Значение из текущего времени
    public static String getValuefromCurrentTime() {
        String value = new SimpleDateFormat("ssmmHHddMMyyyy").format(System.currentTimeMillis());
        return value;
    }
    StringBuffer s;
    // Значение текущего времени в милисекундах
    public static Long getTimeInMils() {
        Long value = System.currentTimeMillis();
        return value;
    }
}
