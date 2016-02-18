package com.asadmshah.runpainter.models;

import android.os.Parcelable;

import auto.parcel.AutoParcel;

@AutoParcel
public abstract class Run implements Parcelable {

    public abstract long id();
    public abstract long datetime();
    public abstract long distance();
    public abstract long duration();
    public abstract int format();
    public abstract int colorA();
    public abstract int colorB();
    public abstract int colorText();
    public abstract int colorPath();

    public static Run create(long id, long datetime, long distance, long duration, int format, int ca, int cb, int ctext, int cpath) {
        return new AutoParcel_Run.Builder()
                .id(id)
                .datetime(datetime)
                .distance(distance)
                .duration(duration)
                .format(format)
                .colorA(ca)
                .colorB(cb)
                .colorText(ctext)
                .colorPath(cpath)
                .build();
    }

    @AutoParcel.Builder
    public abstract static class Builder {
        public abstract Builder id(long l);
        public abstract Builder datetime(long l);
        public abstract Builder distance(long l);
        public abstract Builder duration(long l);
        public abstract Builder format(int i);
        public abstract Builder colorA(int i);
        public abstract Builder colorB(int i);
        public abstract Builder colorText(int i);
        public abstract Builder colorPath(int i);
        public abstract Run build();
    }

}
