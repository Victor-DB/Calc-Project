package com.tasks.review.sort.array;

import java.util.stream.IntStream;

public class Main {

    //    пузырьковая сортировка:
    static int[] getSortArrAsc(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j <= arr.length - i - 2; j++){
                if (arr[j] >= arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arrayEven = {7, 23, 1, 6, 3 , 9, 35, 4, 87, 21};
        int[] arrayOdd = {7, 23, 1, 87, 3 , 9, 35, 4, 2};

        IntStream.of(getSortArrAsc(arrayEven)).forEach(System.out::println);
    }
}
