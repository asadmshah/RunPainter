package com.asadmshah.runpainter;

import android.app.Application;
import android.content.Context;

import com.asadmshah.runpainter.injection.components.ApplicationComponent;
import com.asadmshah.runpainter.injection.factories.ApplicationComponentFactory;

public class RunPainterApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = ApplicationComponentFactory.create(this);
    }

    public static ApplicationComponent getComponent(Context context) {
        return ((RunPainterApplication) context.getApplicationContext()).applicationComponent;
    }

}
