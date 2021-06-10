package com.tasks.recursive;

import java.util.HashSet;
import java.util.Set;

public class Perebor {

    public static void replaceItem(String[] arr, int index1, int index2) {
        String temp = arr[index2];
        arr[index2] = arr[index1];
        arr[index1] = temp;
    }

    public static void recurseSimple(int n) {
        if(n == 0) return;
        System.out.println(n);
        n--;
        recurseSimple(n);
    }

    public static void recursive(int index, String[] arr, String[] arrTemp ) {
        String temp = "";
        for (int j = 0; j < arr.length; j++) {
            temp = temp + arr[j];
            arrTemp[j] = arr[j];
        }
        //System.out.println(temp);
        /////////// temp
            int n = arrTemp.length - 1;
            recur(arrTemp, n);
        ///////////
        if (index == 5) return;
        replaceItem(arr, 0, index);
        index++;
        recursive(index, arr, arrTemp);
    }

    // 1. index = arr3.length - 1
    public static void recur (String[] arrTemp, int index) {
        String s = "";
        for (int i = 0; i < arrTemp.length; i++) {
            s += arrTemp[i];                            System.out.print(arrTemp[i] + " ");
        }
        replaceItem(arrTemp, index - 1, index);
        index--;
        System.out.println("\n"); //set.add(s);
        if (index == 0) return;
        recur(arrTemp, index);
    }

    public static void main(String[] args) {

        String[] arr = {"a", "b", "c", "d", "e"};
        String[] arrTemp = new String[5];

//        String temp = "";
//        for (int j = 0; j < arr.length; j++) {
//            temp = temp + arr[j];
//        }
//        System.out.println(temp);
//        replaceItem(arr, 0, 1);

        int index = 1;
        recursive(index, arr, arrTemp);





        String[] arr3 = {"a", "b", "c", "d"};
        String s = "";
        Set<String> set = new HashSet<>();
        //recurseSimple(5);

       // recur(arr3,3);





//            for (int i = 0; i < arr3.length; i++) {
//                s += arr[i];                            System.out.print(arr3[i] + " ");
//                if (arr3.length - i - 2 > 0) {
//                    if (i == arr3.length - 1) {
//                        replaceItem(arr3, arr3.length - i - 2, arr3.length - i - 1);
//                    }
//                }
//            } System.out.println("\n"); //set.add(s);
//
//
//            for (int i = 0; i < arr3.length; i++) {
//                s += arr[i];                            System.out.print(arr3[i] + " ");
//            } System.out.println("\n"); //set.add(s);
//
//
//            replaceItem(arr3, 0, arr3.length -1);
//            for (int i = 0; i < arr3.length; i++) {
//                s += arr[i];                            System.out.print(arr3[i] + " ");
//                if (i == arr3.length - 1) {
//                    replaceItem(arr3, arr3.length - 2, arr3.length - 1);
//                }
//            } System.out.println("\n"); //set.add(s);
//
//
//            for (int i = 0; i < arr3.length; i++) {
//                s += arr[i];                            System.out.print(arr3[i] + " ");
//            } System.out.println("\n"); //set.add(s);
//
//
//            replaceItem(arr3, 0, arr3.length -1);
//            for (int i = 0; i < arr3.length; i++) {
//                s += arr[i];                            System.out.print(arr3[i] + " ");
//                if (i == arr3.length - 1) {
//                    replaceItem(arr3, arr3.length - 2, arr3.length - 1);
//                }
//            } System.out.println("\n"); //set.add(s);
//
//
//            for (int i = 0; i < arr3.length; i++) {
//                s += arr[i];                            System.out.print(arr3[i] + " ");
//            } System.out.println("\n"); //set.add(s);




    }
}
