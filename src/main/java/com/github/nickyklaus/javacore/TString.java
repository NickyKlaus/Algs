package com.github.nickyklaus.javacore;

import java.util.Arrays;

public class TString {
    public static void main(String[] args) {
        String names = " bellA   alena    Agnes \n anette albina   Anastasya  \tRosA Mary      ";
        System.out.println(names);
        names = names.strip();
        System.out.println(names);
        String[] arr = names.split("\\s+");

        System.out.println("\nORIGINAL:\n" + Arrays.toString(arr));

        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j].compareToIgnoreCase(arr[i]) < 0) {
                    String temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }                
            }
        }

        System.out.println("\nSORTED:\n" + Arrays.toString(arr));
    }
}
