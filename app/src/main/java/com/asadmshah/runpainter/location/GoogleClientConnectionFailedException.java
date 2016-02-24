package com.asadmshah.runpainter.location;

import com.google.android.gms.common.ConnectionResult;

public class GoogleClientConnectionFailedException extends RuntimeException {

    private final ConnectionResult connectionResult;

    GoogleClientConnectionFailedException(ConnectionResult connectionResult) {
        this.connectionResult = connectionResult;
    }

    public ConnectionResult getConnectionResult() {
        return connectionResult;
    }
}
