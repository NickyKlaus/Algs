package com.github.nickyklaus.minimalprefix;

import java.util.Arrays;

public class MinimalPrefix {
    public static void main(String[] args) {
        int[] values = { 1, 2, 3, 4, 5 };
        int sum = 3;

        System.out.println(equalArrays(minimalPrefix(values, sum), new int[]{1,2}));

        values = new int[]{};
        System.out.println(equalArrays(minimalPrefix(values, sum), new int[]{}));
    }

    static int[] minimalPrefix(int[] values, int sum) {
        long s = 0;
        int index = 0;

        if (values == null) {
            return new int[0];
        }

        while (index < values.length && s <= sum) {
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
