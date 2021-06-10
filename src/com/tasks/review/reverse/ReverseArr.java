package com.tasks.review.reverse;

import java.util.stream.IntStream;

public class ReverseArr {

    static int[] fastReverse(int[] arr) {
        long start = System.nanoTime();
        int iters = arr.length/2 - 1;
        for (int i = 1; i <= iters + 1; i++) {
            int temp = arr[iters - i + 1];
            arr[iters - i + 1] = arr[iters + i] ;
            arr[iters + i] = temp;
        }
        long end = System.nanoTime();
        System.out.print("time diff: ");
        System.out.println(end - start);
        return arr;

    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        int[] arrReverse = fastReverse(arr);

        IntStream.of(arrReverse).forEach(System.out::println);
    }
}
