package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class LoggerTests {
    Logger logger = LogManager.getLogger(LoggerTests.class);
    Logger fileLogger = LogManager.getLogger("File");

    @Test
    public void logTest() {
        logger.trace("Trace Message: Начало теста...");
        logger.debug("Debug Message: ...");
        logger.info("Info Message: ...");
        logger.warn("Warning Message: ...");
        logger.error("Error Message: ...");
        logger.fatal("Fatal Message: ...");
/*
        fileLogger.trace("Trace Message: Начало теста...");
        fileLogger.debug("Debug Message: ...");
        fileLogger.info("Info Message: ...");
        fileLogger.warn("Warning Message: ...");
        fileLogger.error("Error Message: ...");
        fileLogger.fatal("Fatal Message: ...");
*/
    }

    @Test
    public void loginTest() {
        logger.trace("login test is started...");

        logger.trace("инициализируем начальные переменные...");
        int a = 10;
        int b = 0;

        if (b == 0) {
            logger.fatal("Делитель равен нулю...");
        }
        // int c = a / b;

        logger.trace("login test is finished...");
    }
}
