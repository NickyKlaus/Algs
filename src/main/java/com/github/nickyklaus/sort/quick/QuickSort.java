package com.github.nickyklaus.sort.quick;

import java.util.Arrays;

public class QuickSort {
    // Переписать - неправильный выход из рекурсии см. Quick sort для java

    public static void main(String[] args) {
        int[] values;

        values = null;
        System.out.println("\nORIGINAL: " + Arrays.toString(values));
        quickSort(values, 0, 0);
        System.out.println("\nSORTED: " + Arrays.toString(values));

        values = new int[]{};
        System.out.println("\nORIGINAL: " + Arrays.toString(values));
        quickSort(values, 0, values.length-1);
        System.out.println("\nSORTED: " + Arrays.toString(values));

        values = new int[]{1};
        System.out.println("\nORIGINAL: " + Arrays.toString(values));
        quickSort(values, 0, 1);
        System.out.println("\nSORTED: " + Arrays.toString(values));

        values = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println("\nORIGINAL: " + Arrays.toString(values));
        quickSort(values, 0, values.length-1);
        System.out.println("\nSORTED: " + Arrays.toString(values));

        values = new int[]{1, 3, 2, 4, 5, 6, 7, 8, 9};
        System.out.println("\nORIGINAL: " + Arrays.toString(values));
        quickSort(values, 0, values.length-1);
        System.out.println("\nSORTED: " + Arrays.toString(values));

        values = new int[]{9, 3, 2, 4, 5, 6, 7, 8, 1};
        System.out.println("\nORIGINAL: " + Arrays.toString(values));
        quickSort(values, 0, values.length-1);
        System.out.println("\nSORTED: " + Arrays.toString(values));

        values = new int[]{9, 3, 2, 5, 4, 6, 7, 8, 1};
        System.out.println("\nORIGINAL: " + Arrays.toString(values));
        quickSort(values, 0, values.length-1);
        System.out.println("\nSORTED: " + Arrays.toString(values));

        values = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
        System.out.println("\nORIGINAL: " + Arrays.toString(values));
        quickSort(values, 0, values.length-1);
        System.out.println("\nSORTED: " + Arrays.toString(values));
    }

    // in-place sort
    static void quickSort(int[] values, int begin, int end) {
        if (values == null || values.length < 2 || begin >= end) {
            return;
        }
        int partitionIndex = partition(values, begin, end);
        quickSort(values, begin, partitionIndex-1);
        quickSort(values, partitionIndex+1, end);
    }

    private static int partition(int[] arr, int begin, int end) {
        int pivot = arr[end];
        int nextToSwap = begin;
        int tmp;

        for (int i = begin; i < end; i++) {
            if (arr[i] < pivot) {
                swap(arr, nextToSwap++, i);
            }
        }
        
        swap(arr, nextToSwap, end);
        return nextToSwap;
    }

    private static void swap(int[] arr, int firstElementIndex, int secondElementIndex) {
        int tmp = arr[firstElementIndex];
        arr[firstElementIndex] = arr[secondElementIndex];
        arr[secondElementIndex] = tmp;
    }
}
