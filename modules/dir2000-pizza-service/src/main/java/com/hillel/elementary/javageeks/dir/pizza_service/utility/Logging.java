package com.hillel.elementary.javageeks.dir.pizza_service.utility;

import com.hillel.elementary.javageeks.dir.pizza_service.proxifying.ProxyClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.PrintWriter;
import java.io.StringWriter;

public class Logging {
    public static final Logger LOGGER = LoggerFactory.getLogger(ProxyClass.class);

    public static void logStackTrace(Exception e) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        String sStackTrace = sw.toString();
        LOGGER.error(sStackTrace);
        e.printStackTrace();
    }
}
