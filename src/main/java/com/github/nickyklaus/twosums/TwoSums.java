package com.github.nickyklaus.twosums;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSums {
    public static void main(String[] args) {
        int[] values = {2, 0, 1, 4, 1, 9, 3, 5, 0};
        int sum = 5;

        Arrays.stream(twoSumsQuadraticComplexity(values, sum))
                .peek(i -> System.out.printf("values[%d]=%d\n", i, values[i]))
                .reduce((l, r) -> values[l] + values[r])
                .ifPresent(s -> System.out.printf("Sum is %d\n\n", s));

        Arrays.stream(twoSumsLinearComplexity(values, sum))
                .peek(i -> System.out.printf("values[%d]=%d\n", i, values[i]))
                .reduce((l, r) -> values[l] + values[r])
                .ifPresent(s -> System.out.printf("Sum is %d\n", s));
    }

    static int[] twoSumsQuadraticComplexity(int[] values, int sum) {
        for (int i = 0; i < values.length; i++) {
            for (int j = i + 1; j < values.length; j++) {
                /*if (values[i] + values[j] == sum) {
                    return new int[]{i, j};
                }*/

                if (sum - values[j] == values[i]) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    static int[] twoSumsLinearComplexity(int[] values, int sum) {
        final Map<Integer, Integer> diffToIndex = new HashMap<>();

        for (int i = 0; i < values.length; i++) {
            if (diffToIndex.containsKey(values[i])) {
                return new int[]{diffToIndex.get(values[i]), i};
            }
            diffToIndex.put(sum - values[i], i);
        }

        return new int[]{};
    }
}
