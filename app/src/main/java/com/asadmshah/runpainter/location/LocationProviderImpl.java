package com.asadmshah.runpainter.location;

import android.content.Context;
import android.location.Location;
import android.support.annotation.NonNull;

import com.asadmshah.runpainter.models.RoutePoint;
import com.google.android.gms.location.LocationRequest;

import rx.Observable;

public class LocationProviderImpl implements LocationProvider {

    private static final long INTERVAL = 10000;

    private final Context context;
    private final LocationRequest request;

    public LocationProviderImpl(@NonNull Context context) {
        this.context = context;
        this.request = new LocationRequest()
                .setInterval(INTERVAL)
                .setFastestInterval(INTERVAL/2)
                .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
    }

    @Override
    public Observable<RoutePoint> requestLocationUpdates() {
        return Observable.defer(() -> Observable.create(new GoogleClientOnSubscribe(context))
                .flatMap(client -> Observable.create(new LocationClientOnSubscribe(client, request)))
                .map(LocationProviderImpl::routePointFromLocation));
    }

    private static RoutePoint routePointFromLocation(Location location) {
        return RoutePoint.create(-1, -1, System.currentTimeMillis(),
                location.getLatitude(),
                location.getLongitude(),
                location.getAltitude(),
                location.getAccuracy(),
                location.getBearing(),
                location.getSpeed());
    }
}
