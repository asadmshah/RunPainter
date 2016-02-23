package com.asadmshah.runpainter.database;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.support.annotation.NonNull;

import com.asadmshah.runpainter.models.RoutePoint;
import com.asadmshah.runpainter.models.Run;
import com.squareup.sqlbrite.BriteContentResolver;
import com.squareup.sqlbrite.SqlBrite;

import java.util.List;

import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.functions.Func1;

public class DatabaseImpl implements Database {

    private final ContentResolver cr;
    private final BriteContentResolver bcr;
    private final Scheduler scheduler;

    public DatabaseImpl(@NonNull ContentResolver cr, @NonNull Scheduler scheduler) {
        this.cr = cr;
        this.bcr = SqlBrite.create().wrapContentProvider(cr, scheduler);
        this.scheduler = scheduler;
    }

    @Override
    public Observable<List<Run>> getRuns() {
        return bcr.createQuery(Contracts.Runs.buildUri(), RunQuery.PROJECTION, null, null, RunQuery.SORT_ORDER, true)
                .mapToList(runMapper);
    }

    @Override
    public Observable<Run> getRun(long runId) {
        return bcr.createQuery(Contracts.Runs.buildUri(runId), RunQuery.PROJECTION, null, null, null, true)
                .mapToOne(runMapper);
    }

    @Override
    public Observable<List<RoutePoint>> getRoutePoints(long runId) {
        return bcr.createQuery(Contracts.RoutePoints.buildUri(runId), RoutePointQuery.PROJECTION, null, null, RoutePointQuery.SORT_ORDER, true)
                .mapToList(routePointMapper);
    }

    @Override
    public Observable<Run> insertRun(final @NonNull Run run, final @NonNull List<RoutePoint> routePoints) {
        return Observable.create(new Observable.OnSubscribe<Run>() {
            @Override
            public void call(Subscriber<? super Run> subscriber) {
                ContentValues cvRun = new ContentValues();
                cvRun.put(Contracts.Runs.DATETIME, run.datetime());
                cvRun.put(Contracts.Runs.DISTANCE, run.distance());
                cvRun.put(Contracts.Runs.DURATION, run.duration());
                cvRun.put(Contracts.Runs.FORMAT, run.format());
                cvRun.put(Contracts.Runs.COLOR_BG_A, run.colorA());
                cvRun.put(Contracts.Runs.COLOR_BG_B, run.colorB());
                cvRun.put(Contracts.Runs.COLOR_TEXT, run.colorText());
                cvRun.put(Contracts.Runs.COLOR_PATH, run.colorPath());

                long runId;
                try {
                    runId = ContentUris.parseId(cr.insert(Contracts.Runs.buildUri(), cvRun));
                } catch (Exception e) {
                    subscriber.onError(e);
                    return;
                }

                Run insertedRun = Run.create(runId,
                        run.datetime(),
                        run.distance(),
                        run.duration(),
                        run.format(),
                        run.colorA(),
                        run.colorB(),
                        run.colorText(),
                        run.colorPath());

                ContentValues[] cvPoints = new ContentValues[routePoints.size()];
                int i = 0;
                for (RoutePoint rp : routePoints) {
                    ContentValues cv = new ContentValues();
                    cv.put(Contracts.RoutePoints.DATETIME, rp.datetime());
                    cv.put(Contracts.RoutePoints.LATITUDE, rp.latitude());
                    cv.put(Contracts.RoutePoints.LONGITUDE, rp.longitude());
                    cv.put(Contracts.RoutePoints.ALTITUDE, rp.altitude());
                    cv.put(Contracts.RoutePoints.ACCURACY, rp.accuracy());
                    cv.put(Contracts.RoutePoints.BEARING, rp.bearing());
                    cv.put(Contracts.RoutePoints.SPEED, rp.speed());
                    cvPoints[i++] = cv;
                }

                try {
                    cr.bulkInsert(Contracts.RoutePoints.buildUri(runId), cvPoints);
                } catch (Exception e) {
                    subscriber.onError(e);
                    return;
                }

                subscriber.onNext(insertedRun);
                subscriber.onCompleted();
            }
        }).subscribeOn(scheduler);
    }

    @Override
    public Observable<Void> deleteRun(final @NonNull Run run) {
        return Observable.create(new Observable.OnSubscribe<Void>() {
            @Override
            public void call(Subscriber<? super Void> subscriber) {
                try {
                    cr.delete(Contracts.Runs.buildUri(run.id()), null, null);
                    subscriber.onCompleted();
                } catch (Exception e) {
                    subscriber.onError(e);
                }
            }
        }).subscribeOn(scheduler);
    }

    @Override
    public Observable<Void> updateRun(final @NonNull Run run) {
        return Observable.create(new Observable.OnSubscribe<Void>() {
            @Override
            public void call(Subscriber<? super Void> subscriber) {
                ContentValues cv = new ContentValues();
                cv.put(Contracts.Runs.DATETIME, run.datetime());
                cv.put(Contracts.Runs.DISTANCE, run.distance());
                cv.put(Contracts.Runs.DURATION, run.duration());
                cv.put(Contracts.Runs.FORMAT, run.format());
                cv.put(Contracts.Runs.COLOR_BG_A, run.colorA());
                cv.put(Contracts.Runs.COLOR_BG_B, run.colorB());
                cv.put(Contracts.Runs.COLOR_TEXT, run.colorText());
                cv.put(Contracts.Runs.COLOR_PATH, run.colorPath());

                try {
                    cr.update(Contracts.Runs.buildUri(run.id()), cv, null, null);
                    subscriber.onCompleted();
                } catch (Exception e) {
                    subscriber.onError(e);
                }
            }
        }).subscribeOn(scheduler);
    }

    private static final Func1<Cursor, Run> runMapper = new Func1<Cursor, Run>() {
        @Override
        public Run call(Cursor cursor) {
            return Run.create(cursor.getLong(RunQuery.ID),
                    cursor.getLong(RunQuery.DATETIME),
                    cursor.getLong(RunQuery.DISTANCE),
                    cursor.getLong(RunQuery.DURATION),
                    cursor.getInt(RunQuery.FORMAT),
                    cursor.getInt(RunQuery.COLOR_BG_A),
                    cursor.getInt(RunQuery.COLOR_BG_B),
                    cursor.getInt(RunQuery.COLOR_TEXT),
                    cursor.getInt(RunQuery.COLOR_PATH)
            );
        }
    };

    private static final Func1<Cursor, RoutePoint> routePointMapper = new Func1<Cursor, RoutePoint>() {
        @Override
        public RoutePoint call(Cursor cursor) {
            return RoutePoint.create(cursor.getLong(RoutePointQuery.ID),
                    cursor.getLong(RoutePointQuery.RUN_ID),
                    cursor.getLong(RoutePointQuery.DATETIME),
                    cursor.getDouble(RoutePointQuery.LATITUDE),
                    cursor.getDouble(RoutePointQuery.LONGITUDE),
                    cursor.getDouble(RoutePointQuery.ALTITUDE),
                    cursor.getFloat(RoutePointQuery.ACCURACY),
                    cursor.getFloat(RoutePointQuery.BEARING),
                    cursor.getFloat(RoutePointQuery.SPEED)
            );
        }
    };

    private interface RunQuery {
        String[] PROJECTION = new String[]{
                Contracts.Runs.ID,
                Contracts.Runs.DATETIME,
                Contracts.Runs.DISTANCE,
                Contracts.Runs.DURATION,
                Contracts.Runs.FORMAT,
                Contracts.Runs.COLOR_BG_A,
                Contracts.Runs.COLOR_BG_B,
                Contracts.Runs.COLOR_PATH,
                Contracts.Runs.COLOR_TEXT
        };

        int ID = 0;
        int DATETIME = 1;
        int DISTANCE = 2;
        int DURATION = 3;
        int FORMAT = 4;
        int COLOR_BG_A = 5;
        int COLOR_BG_B = 6;
        int COLOR_PATH = 7;
        int COLOR_TEXT = 8;

        String SORT_ORDER = Contracts.Runs.DATETIME + " DESC";
    }

    private interface RoutePointQuery {
        String[] PROJECTION = new String[]{
                Contracts.RoutePoints.ID,
                Contracts.RoutePoints.RUN_ID,
                Contracts.RoutePoints.DATETIME,
                Contracts.RoutePoints.LATITUDE,
                Contracts.RoutePoints.LONGITUDE,
                Contracts.RoutePoints.ALTITUDE,
                Contracts.RoutePoints.ACCURACY,
                Contracts.RoutePoints.BEARING,
                Contracts.RoutePoints.SPEED
        };

        int ID = 0;
        int RUN_ID = 1;
        int DATETIME = 2;
        int LATITUDE = 3;
        int LONGITUDE = 4;
        int ALTITUDE = 5;
        int ACCURACY = 6;
        int BEARING = 7;
        int SPEED = 8;

        String SORT_ORDER = Contracts.RoutePoints.DATETIME + " ASC";
    }
}
