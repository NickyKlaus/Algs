package com.github.nickyklaus.search.binary;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] values = null;
        System.out.println("\n" + Arrays.toString(values));
        System.out.println(binarySearch(values, 1));
        System.out.println(binarySearch(values, 0));


        values = new int[]{};
        System.out.println("\n" + Arrays.toString(values));
        System.out.println(binarySearch(values, 1));
        System.out.println(binarySearch(values, 0));

        values = new int[]{1};
        System.out.println("\n" + Arrays.toString(values));
        System.out.println(binarySearch(values, 1));
        System.out.println(binarySearch(values, 0));

        values = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println("\n" + Arrays.toString(values));
        System.out.println(binarySearch(values, 1));
        System.out.println(binarySearch(values, 2));
        System.out.println(binarySearch(values, 5));
        System.out.println(binarySearch(values, 8));
        System.out.println(binarySearch(values, 9));
        System.out.println(binarySearch(values, 0));
        System.out.println(binarySearch(values, 10));
        System.out.println(binarySearch(values, 100));
    }

    static boolean binarySearch(int[] values, int checking) {
        if (values == null || values.length == 0) {
            return false;
        }

        int middle = 0;
        int low = 0;
        int high = values.length - 1;
        int middleElement;

        while (low <= high) {
            middle = (low + high) / 2;
            middleElement = values[middle];

            if (checking == middleElement) {
                return true;
            }
            if (checking < middleElement) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return false;
    }
}
