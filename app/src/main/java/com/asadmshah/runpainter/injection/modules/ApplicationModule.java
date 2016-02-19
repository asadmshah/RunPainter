package com.asadmshah.runpainter.injection.modules;

import android.content.Context;

import com.asadmshah.runpainter.RunPainterApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private final RunPainterApplication application;

    public ApplicationModule(RunPainterApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public Context providesContext() {
        return application;
    }
}
