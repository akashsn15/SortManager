package com.m3c.as.sorters.binaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinaryTreeImpl implements BinaryTree {

    private Node root;
    private static final String NO_ELEMENT = "ELEMENT NOT FOUND";
    private int elementCount;

    public BinaryTreeImpl(Node root) {
        if(root != null)
            this.root = root;
        elementCount = 1;
    }

    public BinaryTreeImpl(int value) {
        this.root = new Node(value);
        elementCount = 1;
    }
    public BinaryTreeImpl(int[] values) {
        // setting the root as the first value
        this.root = new Node(values[0]);
        elementCount = 1;
        // copying remaining values to be added
        int[] remainingValues = Arrays.copyOfRange(values, 1, values.length);
        addElements(remainingValues);
    }

    @Override
    public int getRootElement() {
        return root.getValue();
    }

    @Override
    public int getNumberOfElements() {
        return elementCount;
    }

    @Override
    public void addElement(int element) {
        Node currentNode = root;
        Node previousNode = root;

        // add only if element does not exist
        if (!findElement(element)) {

            while (currentNode != null)
                if (element < currentNode.getValue()) {
                    previousNode = currentNode;
                    currentNode = previousNode.getLeft();
                    if (currentNode == null) {
                        previousNode.setLeft(new Node(element));
                        elementCount++;
                    }
                } else if (element > currentNode.getValue()) {
                    previousNode = currentNode;
                    currentNode = previousNode.getRight();
                    if (currentNode == null) {
                        previousNode.setRight(new Node(element));
                        elementCount++;
                    }
                }
        }
    }

    @Override
    public void addElements(int[] elements) {
        for (int element : elements)
            addElement(element);
    }

    @Override
    public boolean findElement(int value) {
        Node currentNode = root;

        while(currentNode != null)
            if(value == currentNode.getValue())
                return true;
            else if(value < currentNode.getValue())
                currentNode = currentNode.getLeft();
            else
                currentNode = currentNode.getRight();

        return false;
    }

    @Override
    public int getLeftChild(int element) throws ElementNotFoundException {
        Node currentNode = root;

        while (currentNode != null)
            if (element == currentNode.getValue() && currentNode.getLeft() != null)
                return currentNode.getLeft().getValue();
            else if (element < currentNode.getValue())
                currentNode = currentNode.getLeft();
            else
                currentNode = currentNode.getRight();
        throw new ElementNotFoundException(NO_ELEMENT);
    }

    @Override
    public int getRightChild(int element) throws ElementNotFoundException {
        Node currentNode = root;

        while (currentNode != null)
            if (element == currentNode.getValue() && currentNode.getRight() != null)
                return currentNode.getRight().getValue();
            else if (element < currentNode.getValue())
                currentNode = currentNode.getLeft();
            else
                currentNode = currentNode.getRight();
        throw new ElementNotFoundException(NO_ELEMENT);
    }

    @Override
    public List<Integer> getSortedTreeAsc() {
        List<Integer> sortedListAsc = new ArrayList<Integer>();
        inOrderTraversal(root, sortedListAsc);
        return sortedListAsc;
    }

    @Override
    public List<Integer> getSortedTreeDesc() {
        List<Integer> sortedListDesc = new ArrayList<Integer>();
        reverseInOrderTraversal(root, sortedListDesc);
        return sortedListDesc;
    }

    private void inOrderTraversal(Node currentNode, List<Integer> list) {
        if(currentNode != null) {
            inOrderTraversal(currentNode.getLeft(), list);
            list.add(currentNode.getValue());
            inOrderTraversal(currentNode.getRight(), list);
        }
    }
    private void reverseInOrderTraversal(Node currentNode, List<Integer> list) {
        if(currentNode != null) {
            reverseInOrderTraversal(currentNode.getRight(), list);
            list.add(currentNode.getValue());
            reverseInOrderTraversal(currentNode.getLeft(), list);
        }
    }
}
