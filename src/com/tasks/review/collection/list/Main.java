package com.tasks.review.collection.list;

import java.util.*;

public class Main {

    public static long fillList(List list){
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            list.add(i);
        }
        long end = System.currentTimeMillis();
        return end - start;
    }

    public static void main(String[] args) throws InterruptedException {
        List<Integer> list = new LinkedList<Integer>();
        System.out.println("add LinkedList: " + fillList(list));

        List<Integer> arrList = new ArrayList();
        System.out.println("add ArrayList: " + fillList(arrList));


        long start = System.currentTimeMillis();

        Iterator<Integer> iterator = arrList.iterator();
        while (iterator.hasNext()){
            Integer i = iterator.next();
            list.remove(i);
        }

        long end = System.currentTimeMillis();
        System.out.println("Очистка ArrayList: " + (end - start));


        long start1 = System.currentTimeMillis();

        ListIterator<Integer> listIterator = list.listIterator();
        while (listIterator.hasNext()){
            Integer i = iterator.next();
            list.remove(i);
        }

        long end1 = System.currentTimeMillis();
        System.out.println("Очистка LinkedList: " + (end1 - start1));

    }
}
