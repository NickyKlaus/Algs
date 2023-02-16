package com.github.nickyklaus.javacore;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.IntStream;

public class MinMaxAverage {
    public static void main(String[] args) {
        int N = 10;
        List<Double> reusableDoubles = IntStream.range(0, N).mapToDouble(v -> Math.random()).boxed().toList();

        DoubleSummaryStatistics statistics = reusableDoubles.stream().mapToDouble(v -> v).summaryStatistics();
        System.out.printf("\nMin: %f\nMax: %f\nAverage: %f\n", statistics.getMin(), statistics.getMax(), statistics.getAverage());

        Value<Double> max = new Value<>(0d);
        Value<Double> min = new Value<>(Double.MAX_VALUE);
        Value<Double> sum = new Value<>(0d);

        reusableDoubles.forEach(value -> {
            if (value > max.getValue()) {
                max.setValue(value);
            }
            if (value < min.getValue()) {
                min.setValue(value);
            }
            sum.setValue(value + sum.getValue());
        });

        System.out.printf("\nMin: %s\nMax: %s\nAverage: %f\n", min, max, sum.getValue()/N);
    }

    static class Value<T extends Number> {
        private T value;

        public Value(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }
}
