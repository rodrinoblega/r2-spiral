package com.r2.spiral.frameworks.presenters.instrumentation;

import com.r2.spiral.configuration.Logging;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jImpl implements Logging {

    private final Logger log;

    public Log4jImpl() {
        this.log = LogManager.getLogger(Log4jImpl.class);
    }

    @Override
    public void logMsg(String msg) {
        log.info(msg);
    }
}
