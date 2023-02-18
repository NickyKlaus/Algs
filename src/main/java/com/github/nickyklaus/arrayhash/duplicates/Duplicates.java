package com.github.nickyklaus.arrayhash.duplicates;

import java.util.HashSet;

public class Duplicates {
    // Given an integer array nums, return true if any value appears at least twice in the array,
    // and return false if every element is distinct.
    public static void main(String[] args) {
        System.out.println(containsDuplicates(new int[]{1,2,3,1}));
        System.out.println(containsDuplicates(new int[]{1,2,3,4}));
        System.out.println(containsDuplicates(new int[]{1,1,1,3,3,4,3,2,4,2}));
        System.out.println(containsDuplicates(new int[]{1,1,1,3,3,4,3,2,4,2}));
        System.out.println(containsDuplicates(null));
        System.out.println(containsDuplicates(new int[]{}));
        System.out.println(containsDuplicates(new int[]{1}));
        System.out.println(containsDuplicates(new int[]{1,1}));
    }

    static boolean containsDuplicates(int[] values) {
        if (values == null || values.length < 2) {
            return false;
        }

        HashSet<Integer> set = new HashSet<>();
        for (int value : values) {
            if (set.contains(value)) {
                return true;
            }
            set.add(value);
        }

        return false;
    }
}
