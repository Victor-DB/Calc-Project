package com.tasks.object;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Цель - выяснить как при сравнении по примитивным свойствам фильтруются объекты
 */
public class ObjectPropertyWork {

    static class Ob {
        private List<ObChild> obChild;

        public Ob() {}

        public Ob(List<ObChild> obChild) { this.obChild = obChild; }

        public List<ObChild> getObChild() { return obChild; }

        public void setObChild(List<ObChild> obChild) { this.obChild = obChild; }
    }

    static class ObChild {
        int num;
        String date;

        public ObChild() {}

        public ObChild(int num, String date) {
            this.num = num;
            this.date = date;
        }

        public int getNum() { return num; }

        public void setNum(int num) { this.num = num; }

        public String getDate() { return date; }

        public void setDate(String date) { this.date = date; }
    }

    public static Boolean compareDate(String dateStr, String configDateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        Date configDate = null;
        try {
             date = sdf.parse(dateStr);
             configDate = sdf.parse(configDateStr);
        } catch (ParseException e) { e.printStackTrace(); }

        if (date.after(configDate)){
            return true;
        } else return false;
    }


    public static void main(String[] args) {

        String configDate = "2015-03-03";

        List<Ob> listOb = Arrays.asList(
            new Ob(Arrays.asList(
                new ObChild(1, "2015-01-01"),
                new ObChild(2, "2016-01-01"),
                new ObChild(3, "2016-01-01")
            )),
            new Ob(Arrays.asList(
                new ObChild(1, "2018-02-02"),
                new ObChild(2, "2017-02-02"),
                new ObChild(3, "2015-02-02")
            )),
            new Ob(Arrays.asList(
                new ObChild(1, "2016-03-03"),
                new ObChild(2, "2013-03-03"),
                new ObChild(3, "2014-03-03")
            ))
        );

        List<ObChild> result = new ArrayList<>();
 //......................................................
        listOb.forEach( (ob) -> {                           // requirement (entity)
            ob.getObChild().forEach( obChild -> {           // Fields
                String dateStr = obChild.getDate();         // id, domain, project
                if (compareDate(dateStr, configDate)) {
                    result.add(obChild);
                }
            });
        });
 //.........................................................................
        result.forEach( (obChild) -> {
            System.out.println(obChild.getNum() + " " + obChild.getDate());
        });
 //.........................................................................
    }
}
