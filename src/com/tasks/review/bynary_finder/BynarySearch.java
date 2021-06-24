package com.tasks.review.bynary_finder;

public class BynarySearch {

    static String findNum(int num, int min, int max){

        /** если число за пределами диапазона, то не найдено */
        if ( num > max || num < min ) {
            return "Число " + num + " не найдено";
        }

        /** находим центр отрезка, проверяя чётность длины отрезка */
        int temp = min + max;
        int center = (temp % 2 == 0) ? (temp / 2) : (temp - 1) / 2;

        /** если число в пределах граничных значений, то найдено */
        if ( num == center ||
                num == center  + 1 ||
                num == center  - 1 ||
                num == max ||
                num == min ||
                num == min + 1) {
            return "Число " + num + " найдено";
        }

        System.out.println("center: " + center);

        /** если число больше центра отрезка */
        if (num > center) {
            int newMax = min + max;
            int secondMax = (newMax % 2 == 0) ? (newMax / 2) : (newMax - 1) / 2;
            if (num > secondMax) {
                return findNum(num, secondMax + 1, max);
            } else {
                return findNum(num, center, secondMax - 1);
            }
        }

        /** если число меньше центра отрезка */
        if (num < center) {
            /** пересчитываем центра отрезка */
            int secondCenter = (center % 2 == 0) ? (center / 2) : (center - 1) / 2;
            return findNum(num, min, secondCenter);

        /** если число больше центра отрезка */
        } else {
            return findNum(num, center, max);
        }
    }

    public static void main(String[] args) {
        String message = findNum(55, 1 , 100);
        System.out.println(message);
    }
}
