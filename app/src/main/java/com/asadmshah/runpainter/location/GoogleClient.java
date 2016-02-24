package com.asadmshah.runpainter.location;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;

import timber.log.Timber;

class GoogleClient implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    private final GoogleApiClient client;
    private final Listener listener;

    GoogleClient(@NonNull Context context, @NonNull Listener listener) {
        this.client = new GoogleApiClient.Builder(context)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
        this.listener = listener;
    }

    public void connect() {
        Timber.d("Connecting");
        this.client.connect();
    }

    public void disconnect() {
        Timber.d("Disconnecting");
        this.client.disconnect();
    }

    @Override
    public void onConnected(Bundle bundle) {
        Timber.d("onConnected");
        listener.onGoogleClientConnected(client);
    }

    @Override
    public void onConnectionSuspended(int i) {
        Timber.w("onConnectionSuspended: %d", i);
        listener.onGoogleClientError(new GoogleClientConnectionSuspendedException(i));
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Timber.w("onConnectionFailed: %s", connectionResult.getErrorMessage());
        listener.onGoogleClientError(new GoogleClientConnectionFailedException(connectionResult));
    }

    interface Listener {
        void onGoogleClientConnected(GoogleApiClient client);
        void onGoogleClientError(Throwable throwable);
    }
}
