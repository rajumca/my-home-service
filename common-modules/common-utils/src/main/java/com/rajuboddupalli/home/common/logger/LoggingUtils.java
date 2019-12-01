package com.rajuboddupalli.home.common.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingUtils {
    private static  Logger logger=LoggerFactory.getLogger(LoggingUtils.class);

    public static void logInfo(String message,String ...args) {
        logger.info(message,args);
    }
    public static void logError(String message, Throwable throwable) {
        logger.error(message,throwable);
    }
    public static void logDebug(String message,String ...args) {
        logger.debug(message,args);
    }

}
