package com.m3c.as;

import com.m3c.as.sorters.BubbleSorter;
import com.m3c.as.sorters.Sorter;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class SortTester {

    public Sorter sorter;

    @Before
    public void setup() {
        sorter = new BubbleSorter();
    }

    @Test
    public void testEmptyArray() {
        int[] emptyArray = {};
        int[] sortedArray = sorter.sort(emptyArray);
        Assert.assertEquals(0, sortedArray.length);
    }

    @Test
    public void testSort() {
        int expectedArray[] = {1,2,3,4};
        int unsortedArray[] = {4,3,1,2};
        Assert.assertArrayEquals(expectedArray, sorter.sort(unsortedArray));
    }

    @Test
    public void testSortSingleElement() {
        int expectedArray[] = {9};
        int array[] = {9};
        Assert.assertArrayEquals(expectedArray, sorter.sort(array));
    }

    @Test(expected = NullPointerException.class)
    public void testNull() {
        sorter.sort(null);
    }

    @After
    public void teardown() {

    }
}