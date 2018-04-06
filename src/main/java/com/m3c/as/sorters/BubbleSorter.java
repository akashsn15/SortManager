package com.m3c.as.sorters;

import java.util.Arrays;

public class BubbleSorter implements Sorter {
    // bubble sort
    @Override
    public int[] sort(int[] array) {
        int swap = 0;
        for (int i = 0; i < array.length; i++)
            for (int j = 1; j < array.length - i; j++) {
                if (array[j -1] > array[j]) {
                    swap = array[j -1];
                    array[j-1] = array[j];
                    array[j] = swap;
                }
            }
        return array;
    }
    @Override
    public String toString() {
        return "Bubble Sort";
    }
}