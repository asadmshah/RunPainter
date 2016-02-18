package com.asadmshah.runpainter.models;

import android.os.Parcelable;

import auto.parcel.AutoParcel;

@AutoParcel
public abstract class RoutePoint implements Parcelable {

    public abstract long id();
    public abstract long runId();
    public abstract long datetime();
    public abstract double latitude();
    public abstract double longitude();
    public abstract double altitude();
    public abstract float accuracy();
    public abstract float bearing();
    public abstract float speed();

    public static RoutePoint create(long id, long runId, long datetime, double lat, double lon, double altitude, float accuracy, float bearing, float speed) {
        return new AutoParcel_RoutePoint.Builder()
                .id(id)
                .runId(runId)
                .datetime(datetime)
                .latitude(lat)
                .longitude(lon)
                .altitude(altitude)
                .accuracy(accuracy)
                .bearing(bearing)
                .speed(speed)
                .build();
    }

    @AutoParcel.Builder
    public abstract static class Builder {
        public abstract Builder id(long l);
        public abstract Builder runId(long l);
        public abstract Builder datetime(long l);
        public abstract Builder latitude(double d);
        public abstract Builder longitude(double d);
        public abstract Builder altitude(double d);
        public abstract Builder accuracy(float f);
        public abstract Builder bearing(float f);
        public abstract Builder speed(float f);
        public abstract RoutePoint build();
    }

}
