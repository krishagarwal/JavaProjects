package com.company.logging;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Main {

    public static void main(String[] args) {

        Logger pkgLogger = Logger.getLogger("com.company.logging");
        Logger logger = Logger.getLogger("com.company.logging.Main");
        FileHandler fh;

        try {

            // This block configure the logger with handler and formatter
            fh = new FileHandler("C:\\Users\\krish\\IdeaProjects\\Logging\\src\\MyLogFile.log.txt", true);
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);

            logger.setLevel(Level.ALL);

        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        FileHandler fh2;

        try {

            // This block configure the logger with handler and formatter
            fh2 = new FileHandler("C:\\Users\\krish\\IdeaProjects\\Logging\\src\\MyLogFile2.log.txt", true);
            pkgLogger.addHandler(fh2);
            SimpleFormatter formatter = new SimpleFormatter();
            fh2.setFormatter(formatter);

            pkgLogger.setLevel(Level.ALL);

        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        logger.entering("com.company.logging.Main", "main", "2nd time");
        logger.logp(Level.FINEST, "com.company.logging.Main", "main", "it appends");
        logger.log(Level.FINE, "it appends");
        logger.exiting("com.company.logging.Main", "main", "2nd time");

    }

}
