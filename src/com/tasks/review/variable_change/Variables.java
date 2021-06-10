package com.tasks.review.variable_change;

public class Variables {

    static void changeVars(int a, int b){
        System.out.println("before: " + a + " " + b);
        // a = 1  b = 3
        a = a - b;

        // a = -2   b = 3
        b = b + a;

        // a = -2   b = 1
        a = b - a;
        System.out.println("after: " + a + " " + b);
    }

    public static void main(String[] args) {
        changeVars(1, 3);
    }
}
