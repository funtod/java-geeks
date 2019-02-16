package com.hillel.elementary.javageeks.dir.sockets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.PrintWriter;
import java.io.StringWriter;

public class Logging {
    public static final Logger LOGGER = LoggerFactory.getLogger(Logging.class);

    public static void logFailure(Exception e) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);

        pw.println(e.getMessage());
        e.printStackTrace(pw);

        String sStackTrace = sw.toString();
        LOGGER.error(sStackTrace);
    }
}
