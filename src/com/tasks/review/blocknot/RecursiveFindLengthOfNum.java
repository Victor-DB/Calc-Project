package com.tasks.review.blocknot;

import java.util.ArrayList;
import java.util.List;

public class RecursiveFindLengthOfNum {

    private static List<Integer> list = new ArrayList<>();

    public static void getArrNums(int num, int length) {
        if (length == 0) return;

        if (num == 10) {
            list.add(num % 10);
            list.add(num / 10);
            return;
        } else {
            list.add(num % 10);
            length--;
            getArrNums(num / 10, length);
        }
    }

    public static int getRecursiveLength(int num, int count) {
        count++;
         if (num >= 10) {
             num = num / 10;
             return getRecursiveLength(num, count);
         } else if (0 <= num) {
             return count;
         }
        return count + 1;
    }

    public static void main(String[] args) {
        int length = getRecursiveLength(123, 0);
        System.out.println("length: " + length);
        getArrNums(123, length);
        list.stream().forEach(System.out::println);
    }
}
