package com.tasks.review;

interface BB{
    // public static final
    int bb = 1;
    int getBb();

    // public abstract non-static
    int del();

    // public static
    static String getStr(){
        return "fdafdaa";
    }
}

 class FClass{
    int f;
    int getNum(){
        return 1 + 2;
    }

     public FClass(int f) {
         this.f = f;
     }
 }

class C extends FClass implements BB{

    public C(int f) {
        super(f);
    }

    @Override
    public int getBb() { return 0; }

    @Override
    public int del() { return 0; }
}

abstract class B {
    char b = 'b';
    public char getB() { return b; }

    abstract int add(int a, int b);

}


class A extends B {
    int a;
    public int getA() { return a; }

    // !!!
    @Override
    int add(int a, int b) {
        return a + b;
    }

}


public class Main {
    public static void main(String[] args) {

    }
}
