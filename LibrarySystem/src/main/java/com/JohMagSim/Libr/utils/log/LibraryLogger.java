package com.JohMagSim.Libr.utils.log;

import java.io.*;
import java.util.logging.*;

public class LibraryLogger {
    private static FileHandler fileTxt;
    private static SimpleFormatter formatterTxt;
    private static ConsoleHandler consolehandler;

    public static void setup() throws IOException {
        Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        Logger rootLogger = Logger.getLogger("");
        Handler[] handlers = rootLogger.getHandlers();
        if (handlers[0] instanceof ConsoleHandler) {
            rootLogger.removeHandler(handlers[0]);
        }

        logger.setLevel(Level.SEVERE);
        fileTxt = new FileHandler("Logging.txt");

        formatterTxt = new SimpleFormatter();
        fileTxt.setFormatter(formatterTxt);
        logger.addHandler(fileTxt);
    }

    /**
     * This is the logger for development. It writes out things to the console and file.
     * @param mode
     * @throws IOException
     */
    public static void setup(String mode) throws IOException {
        Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        Logger rootLogger = Logger.getLogger("");

        Handler[] handlers = rootLogger.getHandlers();
        if (handlers[0] instanceof ConsoleHandler) {
            rootLogger.removeHandler(handlers[0]);
        }

        logger.setLevel(Level.FINER);
        fileTxt = new FileHandler("Logging.txt");

        formatterTxt = new SimpleFormatter();
        fileTxt.setFormatter(formatterTxt);
        logger.addHandler(fileTxt);

        Formatter consolelogForm = new ConsoleLogFormatter();

        consolehandler = new ConsoleHandler();
        consolehandler.setLevel(Level.ALL);
        consolehandler.setFormatter(consolelogForm);
        logger.addHandler(consolehandler);
    }

}
