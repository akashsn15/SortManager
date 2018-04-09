package com.m3c.as;

import com.m3c.as.controller.SortManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Starter
{
    private static final String LOG_PROPERTIES_FILE = "resources/log4j.properties";
    private static Logger LOGGER = Logger.getLogger(Starter.class.getName());

    public static void main( String[] args )
    {
        initialiseLogging();
        SortManager sortManager = new SortManager();
        sortManager.sortArray();
    }
    public static void initialiseLogging() {
        PropertyConfigurator.configure(LOG_PROPERTIES_FILE);
        LOGGER.info("Logging initialised");
    }

}
