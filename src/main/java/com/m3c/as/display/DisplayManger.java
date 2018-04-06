package com.m3c.as.display;

import com.m3c.as.sorters.Sorter;

import java.text.DecimalFormat;
import java.util.Arrays;

public class DisplayManger {

    public void displaySortType(Sorter sorter) {
        System.out.println("Sort Using: " + sorter.toString()+ "\n");
    }

    public void displayUnsortedArray(int[] array) {
        System.out.println("Unsorted Array");
        System.out.println(Arrays.toString(array) + "\n");
    }

    public void displaySortedArray(int[] array, long time) {
        DecimalFormat df = new DecimalFormat("###,###.####");
        System.out.println("Sorted Array");
        System.out.println(Arrays.toString(array) + "\n");
        System.out.println("Time Taken = " + df.format(time));
    }

    public void displayExceptionMessage(String message) {
        System.out.println(message);
    }
}
