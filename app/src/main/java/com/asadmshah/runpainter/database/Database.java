package com.asadmshah.runpainter.database;

import android.support.annotation.NonNull;

import com.asadmshah.runpainter.models.RoutePoint;
import com.asadmshah.runpainter.models.Run;

import java.util.List;

import rx.Observable;

public interface Database {

    Observable<List<Run>> getRuns();

    Observable<Run> getRun(long runId);

    Observable<List<RoutePoint>> getRoutePoints(long runId);

    Observable<Run> insertRun(@NonNull Run run, @NonNull List<RoutePoint> routePoints);

    Observable<Void> deleteRun(@NonNull Run run);

    Observable<Void> updateRun(@NonNull Run run);
}
