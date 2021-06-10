package com.tasks.string;

import java.util.*;

/**
 * Output numbers of loto tickets without duplicates
 */
public class Main {

    static class Ticket {
       protected int a;
       protected int b;
       protected int c;
       protected int d;
       protected int e;

        public Ticket() {}

        public Ticket(int a, int b, int c, int d, int e) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
            this.e = e;
        }

        public int getA() { return a; }

        public void setA(int a) { this.a = a; }

        public int getB() { return b; }

        public void setB(int b) { this.b = b; }

        public int getC() { return c; }

        public void setC(int c) { this.c = c; }

        public int getD() { return d; }

        public void setD(int d) { this.d = d; }

        public int getE() { return e; }

        public void setE(int e) { this.e = e; }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Ticket ticket = (Ticket) o;
            return getA() == ticket.getA() &&
                    getB() == ticket.getB() &&
                    getC() == ticket.getC() &&
                    getD() == ticket.getD() &&
                    getE() == ticket.getE();
        }

        @Override
        public int hashCode() {
            return Objects.hash(getA(), getB(), getC(), getD(), getE());
        }

        @Override
        public String toString() {
            return "Ticket{" +
                    "a=" + a +
                    ", b=" + b +
                    ", c=" + c +
                    ", d=" + d +
                    ", e=" + e +
                    '}';
        }
    }

    static Map<Integer,Ticket> fillTickets(int n) {
        Map<Integer,Ticket> map = new TreeMap<>();
        int count = 0;
        for(int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    for (int m = 1; m <= n; m++) {
                        for (int l = 1; l <= n; l++) {
                            count++;
                            Ticket ticket = new Ticket(i, j, k, m, l);
                            map.put(count, ticket);
                        }
                    }
                }
            }
        }
        return map;
    }


    static int sort(String str) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            String s = str.substring(i, i + 1);
            int n1 = Integer.parseInt(s);
            list.add(n1);
        }

        Collections.sort(list);
        String stroka ="";
        for(int j = 0; j < list.size(); j++) { stroka = stroka + list.get(j)+ "";}
        stroka.trim();
        return Integer.parseInt(stroka);
    }

    public static void main(String[] args) {

//        Map<Integer, Ticket> map = fillTickets(10);
//
//        map.entrySet().forEach( (m) -> {
//            System.out.println(m.getKey() + " : " + m.getValue().toString());
//        });

        int n = 10;
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        String cash = null;

        for(int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    for (int m = 1; m <= n; m++) {
                        for (int l = 1; l <= n; l++) {
                            cash = i + "" + j + "" + k + "" + m + "" + l;

                            cash.trim();
                            int x = sort(cash);
                            map.put(x, x);
                        }
                    }
                }
            }
        }


        int count = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey());
            count++;
        }

        System.out.println(count);
    }
}



