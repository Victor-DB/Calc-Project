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


    static int[] quickSort(int[] array){
      //  int[] arrayOdd = {7, 23, 1, 87, 3 , 9, 35, 4, 2};

        int[] arrLess = new int[array.length];
        int[] arrMore = new int[array.length];

        int indexOpor = 0;
        if (array.length % 2 != 0) {
            indexOpor = (array.length - 1) / 2;
            System.out.println("oporniy element: " + array[indexOpor]);

            for (int i = 0; i < indexOpor; i++) {
                System.out.println("down: " + array[indexOpor - i - 1]);
                System.out.println("up: " + array[indexOpor + i + 1]);

               if (array[indexOpor] > array[indexOpor - i - 1]) {
                   /** Элемент меньше опорного, то в массив меньше */
                   arrLess[i] = array[indexOpor - i - 1];
//                   System.out.println("less: " + array[indexOpor - i]);

               } else if (array[indexOpor] <= array[indexOpor - i - 1]) {
                   /** Элемент больше опорного, то в массив больше */
                   arrMore[i] = array[indexOpor - i - 1];
//                   System.out.println("more: " + array[indexOpor + i + 1]);
               }


                if (array[indexOpor] > array[indexOpor + i + 1]) {
                    /** Элемент меньше опорного, то в массив меньше */
                    arrLess[i] = array[indexOpor + i + 1];
//                    System.out.println("less: " + array[indexOpor + i + 1]);

                } else if (array[indexOpor] <= array[indexOpor + i + 1]) {
                    /** Элемент больше опорного, то в массив больше */
                    arrMore[i] = array[indexOpor + i + 1];
//                    System.out.println("more: " + array[indexOpor + i + 1]);
                }

            }

        } else {
            indexOpor = array.length / 2 - 1;
            System.out.println(array[indexOpor]);
        }

        IntStream.of(arrLess).forEach(System.out::println);
        IntStream.of(arrMore).forEach(System.out::println);

        return array;
    }




    public static void main(String[] args) {
        int[] arrayEven = {7, 23, 1, 6, 3 , 9, 35, 4, 87, 21};
        int[] arrayOdd = {7, 23, 1, 87, 3 , 9, 35, 4, 2};
        int[] array = {1};
        System.out.println("arr_length " + array.length);

//        IntStream.of(getSortArrAsc(arrayEven)).forEach(System.out::println);
        int[] a = quickSort(arrayOdd);
    }
}
