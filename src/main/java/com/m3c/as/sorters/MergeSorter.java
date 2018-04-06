package com.m3c.as.sorters;

import java.sql.SQLOutput;
import java.util.Arrays;

public class MergeSorter implements Sorter{

    private int[] array;
    private int[] tempArray;
    private int length;

    @Override
    public String toString() {
        return "Merge Sort";
    }

    @Override
    public int[] sort(int[] array) {
        this.array = array;
        this.length = array.length;
        this.tempArray = new int[length];
        split(0, length-1);

        return array;
    }

    // split array
    public void split(int l, int r){
        if(l<r){
            int m = l+(r-l) / 2;
            split(l,m);
            split(m+1, r);
            merge(l,m,r);
        }
    }

    // sorts array while merging
    public void merge(int l, int m, int r){
        for(int i = l; i <= r; i++)
            tempArray[i] = array[i];
        int i = l, k = l;
        int j = m+1;

        while(i <= m && j <= r){
            if(tempArray[i] <= tempArray[j]){
                array[k] = tempArray [i];
                i++;
            }
            else{
                array[k] = tempArray[j];
                j++;
            }
            k++;
        }

        while (i <= m) {
            array[k] = tempArray[i];
            k++;
            i++;
        }
    }
}
