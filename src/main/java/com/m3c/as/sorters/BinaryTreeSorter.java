package com.m3c.as.sorters;

import com.m3c.as.sorters.binaryTree.BinaryTree;
import com.m3c.as.sorters.binaryTree.BinaryTreeImpl;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeSorter implements Sorter{
    @Override
    public int[] sort(int[] array) {
        BinaryTree binaryTree = new BinaryTreeImpl(array);
        List<Integer> sortedList = new ArrayList<>();
        sortedList = binaryTree.getSortedTreeAsc();
        int[] sortedArray = sortedList.stream().mapToInt(i->i).toArray();
        return sortedArray;
    }
    @Override
    public String toString() {
        return "Binary Tree Sort";
    }
}
