package com.m3c.as.controller;

import com.m3c.as.Starter;
import com.m3c.as.display.DisplayManger;
import com.m3c.as.sorters.Sorter;
import org.apache.log4j.PropertyConfigurator;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.Logger;

public class SortManager {

    private static final String LOG_PROPERTIES_FILE = "resources/log4j.properties";
    private static org.apache.log4j.Logger LOGGER = org.apache.log4j.Logger.getLogger(SortManager.class.getName());

    private int[] createArray(int size)  {
        Random random = new Random();
        int[] unsortedArray = new int [size];
        for (int i = 0; i < size; i++) {
            unsortedArray[i] = random.nextInt(size*10);
        }
        return unsortedArray;
    }

    public void sortArray() {
        initialiseLogging();
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
    public static void initialiseLogging() {
        PropertyConfigurator.configure(LOG_PROPERTIES_FILE);
        LOGGER.info("Logging initialised");
    }
}