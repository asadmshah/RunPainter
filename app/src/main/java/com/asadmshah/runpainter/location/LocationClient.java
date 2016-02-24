package com.asadmshah.runpainter.location;

import android.location.Location;
import android.support.annotation.NonNull;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

import timber.log.Timber;

class LocationClient implements LocationListener {

    private final GoogleApiClient client;
    private final LocationRequest request;
    private final Listener listener;

    LocationClient(@NonNull GoogleApiClient client, @NonNull LocationRequest request, @NonNull Listener listener) {
        this.client = client;
        this.request = request;
        this.listener = listener;
    }

    public void connect() {
        Timber.d("Connecting");
        try {
            LocationServices.FusedLocationApi.requestLocationUpdates(client, request, this);
        } catch (SecurityException e) {
            listener.onSecurityException(e);
        }
    }

    public void disconnect() {
        if (client.isConnected()) {
            Timber.d("Disconnecting");
            LocationServices.FusedLocationApi.removeLocationUpdates(client, this);
        }
    }

    @Override
    public void onLocationChanged(Location location) {
        listener.onLocationChanged(location);
    }

    interface Listener {
        void onLocationChanged(Location location);
        void onSecurityException(SecurityException exception);
    }

}
