package ru.bh.level3.les6;


import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainApp {
    // Trace < Debug < Info < Warn < Error < Fatal - importance level

    private static final Logger LOGGER = LogManager.getLogger(MainApp.class);

    public static void main(String[] args) {
        System.out.println(LOGGER.getName());

        LOGGER.trace("Trace");
        LOGGER.debug("Debug");
        LOGGER.info("Info");
        LOGGER.warn("Warn");
        LOGGER.error("Error");
        LOGGER.fatal("Fatal");
        LOGGER.info("String: {}.", "Hello, world");
        a();
    }

    public static void a() {
        try {
            throw new RuntimeException("123");
        } catch (RuntimeException e) {
            LOGGER.throwing(Level.ERROR,e);
        }
    }
}

