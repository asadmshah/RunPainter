package com.asadmshah.runpainter.location;

public class GoogleClientConnectionSuspendedException extends RuntimeException {

    private final int reason;

    GoogleClientConnectionSuspendedException(int reason) {
        this.reason = reason;
    }

    public int getReason() {
        return reason;
    }
}
