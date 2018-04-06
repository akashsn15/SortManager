package com.m3c.as;

import com.m3c.as.sorters.binaryTree.BinaryTree;
import com.m3c.as.sorters.binaryTree.BinaryTreeImpl;
import com.m3c.as.sorters.binaryTree.ElementNotFoundException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class TestBinaryTree {

    public BinaryTree binaryTree;

    @Before
    public void setup()
    {
        binaryTree = new BinaryTreeImpl(7);
        int array[] = {1,5,3,8,12,6};
        binaryTree.addElements(array);

    }

    @Test
    public void testGetRootElement() {
        Assert.assertEquals("Checking root",7,binaryTree.getRootElement());
    }

    @Test
    public void testNumberOfElements() {
        Assert.assertEquals("Size is 7",7,binaryTree.getRootElement());
    }

    @Test
    public void testFindElement() {
        // 5 exists
        Assert.assertTrue(binaryTree.findElement(5));
        // 13 does not exist
        Assert.assertFalse(binaryTree.findElement(13));
    }

    @Test
    public void testGetLeftChild(){
        try {
            // 5 has a left child 3
            Assert.assertEquals(3, binaryTree.getLeftChild(5));
        }
        catch (ElementNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test(expected = ElementNotFoundException.class)
    public void testGetLeftChildException() throws ElementNotFoundException{
        // 1 does not have left child
        binaryTree.getLeftChild(1);
    }

    @Test
    public void testGetRightChild(){
        try {
            // 5 has a right child 6
            Assert.assertEquals(6, binaryTree.getRightChild(5));
        }
        catch (ElementNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test(expected = ElementNotFoundException.class)
    public void testGetRightChildException() throws ElementNotFoundException{
        // 6 does not have right child
        binaryTree.getRightChild(6);
    }

    @Test
    public void testAsc(){
        List<Integer> asc = binaryTree.getSortedTreeAsc();
        Integer[] array = {1,3,5,6,7,8,12};
        Assert.assertArrayEquals(array, asc.toArray());
    }

    @Test
    public void testDesc(){
        List<Integer> asc = binaryTree.getSortedTreeDesc();
        Integer[] array = {12,8,7,6,5,3,1};
        Assert.assertArrayEquals(array, asc.toArray());
    }
}
