package com.asadmshah.runpainter.location;

import android.location.Location;
import android.support.annotation.NonNull;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action0;
import rx.subscriptions.Subscriptions;

class LocationClientOnSubscribe implements Observable.OnSubscribe<Location> {

    private final GoogleApiClient googleClient;
    private final LocationRequest locationRequest;

    LocationClientOnSubscribe(@NonNull GoogleApiClient googleClient, @NonNull LocationRequest locationRequest) {
        this.googleClient = googleClient;
        this.locationRequest = locationRequest;
    }

    @Override
    public void call(Subscriber<? super Location> subscriber) {
        LocationClient locationClient = new LocationClient(googleClient, locationRequest, new LocationClient.Listener() {
            @Override
            public void onLocationChanged(Location location) {
                subscriber.onNext(location);
            }

            @Override
            public void onSecurityException(SecurityException exception) {
                subscriber.onError(exception);
            }
        });
        locationClient.connect();

        subscriber.add(Subscriptions.create(new Action0() {
            @Override
            public void call() {
                locationClient.disconnect();
            }
        }));
    }

}
