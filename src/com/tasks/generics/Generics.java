package com.tasks.generics;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Generics {

    public static <T> T takeIt(T  t) { return t; }

    public static <T> void take(T t) { System.out.println("Do something..."); }

    public static <A, B> boolean compare(Parameter<A, B> p1, Parameter<A, B> p2)  {
        return p1.getA().equals(p2.getA()) && p2.getB().equals(p2.getB());
    }

    public static void notype(List< ? > list) {
        for(Object el : list) { System.out.print(el + " "); }
        System.out.println("\n");
    }

    public static class Parameter<A, B> {
        private A a;
        private B b;

        public Parameter(A a, B b) {
            this.a = a;
            this.b = b;
        }

        public A getA() { return a; }
        public B getB() { return b; }
    }

    public static <T> String assert1(T t) {
        return t.getClass().getSimpleName();
    }


    public static void main(String[] args) {
        String str = takeIt("Привет, друзья!");
        String s = String.format("Today \"%s\" i spend about \"%d\" roubles in a \"%s\"", new Date(), 350, "dinner");
        System.out.println(str);
        System.out.println(s);

        Parameter<String, Integer> p0 = new Parameter<>("one", 1);
        Parameter<String, Integer> p1 = new Parameter<>("one", 1);
        Parameter<String, Integer> p2 = new Parameter<>("two", 2);
        boolean f = compare(p0, p1);
        boolean s1 = compare(p1, p2);
        System.out.println(f);
        System.out.println(s1);

        notype(Arrays.asList("a", "b", "c", "d", "e", "f", "g"));
        notype(Arrays.asList(1, 2, 3, 4, 5, 6, 7));

    }
}
