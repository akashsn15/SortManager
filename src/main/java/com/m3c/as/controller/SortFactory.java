package com.m3c.as.controller;

import com.m3c.as.sorters.BubbleSorter;
import com.m3c.as.sorters.MergeSorter;
import com.m3c.as.sorters.Sorter;
import com.m3c.as.sorters.BinaryTreeSorter;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class SortFactory {

    private static final String TYPE_NOT_FOUND = "Could not run sorter of the given type. Please provide a valid argument";
    private static final String CONFIG_ERROR = "Error while reading file. Ensure your pathname is correct";

    public static Sorter getInstance() throws SortManagerException {
        Properties properties = new Properties();
        try (FileReader fr = new FileReader("resources/factory.properties")){
            properties.load(fr);
            String sorter = properties.getProperty("sorter");

            switch (sorter) {
                case "bubble":
                    return new BubbleSorter();
                case "merge":
                    return new MergeSorter();
                case "binary":
                    return new BinaryTreeSorter();
                default:
                    throw new SortManagerException(TYPE_NOT_FOUND);
            }
        }catch (IOException e) {
            throw new SortManagerException(CONFIG_ERROR);
        }
    }
}
