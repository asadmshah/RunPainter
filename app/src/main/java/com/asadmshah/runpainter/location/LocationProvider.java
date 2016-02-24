package com.asadmshah.runpainter.location;

import com.asadmshah.runpainter.models.RoutePoint;

import rx.Observable;

public interface LocationProvider {

    Observable<RoutePoint> requestLocationUpdates();
}
