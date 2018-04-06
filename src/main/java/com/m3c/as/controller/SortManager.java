package com.m3c.as.controller;

import com.m3c.as.display.DisplayManger;
import com.m3c.as.sorters.Sorter;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.Logger;

public class SortManager {

    Logger logger = Logger.getLogger(SortManager.class.getName());
    private int[] createArray(int size)  {
        Random random = new Random();
        int[] unsortedArray = new int [size];
        for (int i = 0; i < size; i++) {
            unsortedArray[i] = random.nextInt(size*10);
        }
        return unsortedArray;
    }

    public void sortArray() {

        DisplayManger displayManger = new DisplayManger();
        try {
            Sorter sorter = SortFactory.getInstance();

            int[] unsortedArray = createArray(10);

            displayManger.displaySortType(sorter);
            displayManger.displayUnsortedArray(unsortedArray);

            long start = System.nanoTime();
            int[] sortedArray = sorter.sort(unsortedArray);
            long end = System.nanoTime();

            displayManger.displaySortedArray(sortedArray, (end-start));
        } catch (SortManagerException e) {
            displayManger.displayExceptionMessage(e.getMessage());
        }
    }
}