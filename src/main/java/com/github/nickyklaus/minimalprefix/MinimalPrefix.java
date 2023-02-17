package com.github.nickyklaus.minimalprefix;

import java.util.Arrays;

public class MinimalPrefix {
    public static void main(String[] args) {
        int[] values = { 1, 2, 3, 4, 5 };

        System.out.println(equalArrays(minimalPrefix(values, 3), new int[]{1,2}));
        System.out.println(equalArrays(minimalPrefix(values, 15), new int[]{1,2,3,4,5}));
        System.out.println(!equalArrays(minimalPrefix(values, 16), new int[]{1,2,3,4,5}));
        System.out.println(equalArrays(minimalPrefix(values, 0), new int[]{}));

        values = new int[]{0,0,0,0,0,0};
        System.out.println(equalArrays(minimalPrefix(values, 0), new int[]{0}));

        values = new int[]{};
        System.out.println(equalArrays(minimalPrefix(values, 100), new int[]{}));
    }

    static int[] minimalPrefix(int[] values, int sum) {
        long s = 0;
        int index = 0;

        if (values == null) {
            return new int[0];
        }

        while (index < values.length) {
            s += values[index++];
            if (s == sum) {
                return Arrays.copyOfRange(values, 0, index);
            }
        }
        
        return new int[0];
    }

    static boolean equalArrays(int[] actual, int[] expected) {
        return Arrays.equals(actual, expected);
    }
}
