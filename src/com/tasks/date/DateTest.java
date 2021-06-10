package com.tasks.date;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateTest {
    public static void main(String[] args) {

        Long d = 1604299564927L;
        Date date = new Date(d);

        Calendar calendar = Calendar.getInstance();
        Date startDate;
        Date endDate;
        calendar.setTime(date);
        System.out.println("calendar.setTime(date)" + calendar.getTime());

        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), 1, 0, 0, 0);
        System.out.println("calendar.set(...)" + calendar.getTime());

        startDate = calendar.getTime();
        System.out.println("startDate" + startDate);

        calendar.add(Calendar.MONTH, 1);
        endDate = calendar.getTime();
        System.out.println("endDate" + endDate);

        
    }
}
