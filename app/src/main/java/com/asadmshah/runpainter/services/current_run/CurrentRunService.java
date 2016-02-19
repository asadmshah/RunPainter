package com.asadmshah.runpainter.services.current_run;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.asadmshah.runpainter.RunPainterApplication;
import com.asadmshah.runpainter.injection.ComponentFactory;

import javax.inject.Inject;

public class CurrentRunService extends Service implements CurrentRunContract.Service {

    @Inject CurrentRunContract.Manager manager;

    @Override
    public void onCreate() {
        super.onCreate();

        ComponentFactory.create(RunPainterApplication.getComponent(this), this).inject(this);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return Service.START_NOT_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

}
