package com.r2.spiral.configuration;

public class Instrumentation {
    private final Logging logging;

    public Instrumentation(Logging logging) {
        this.logging = logging;
    }

    public void track(String msg) {
        this.logging.logMsg(msg);
    }
}
