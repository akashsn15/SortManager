package com.m3c.as.sorters.binaryTree;

import org.apache.log4j.*;

public class ElementNotFoundException extends Throwable{

    private static final Logger LOGGER = Logger.getLogger(ElementNotFoundException.class);
    public ElementNotFoundException(String message) {
        super(message);
        LOGGER.debug("Element not found exception thrown " + message);
    }
}
