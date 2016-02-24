package com.asadmshah.runpainter.injection.factories;

import com.asadmshah.runpainter.RunPainterApplication;
import com.asadmshah.runpainter.injection.components.ApplicationComponent;
import com.asadmshah.runpainter.injection.components.DaggerApplicationComponent;
import com.asadmshah.runpainter.injection.modules.ApplicationModule;
import com.asadmshah.runpainter.injection.modules.DatabaseModule;
import com.asadmshah.runpainter.injection.modules.LocationProviderModule;

public class ApplicationComponentFactory {

    private ApplicationComponentFactory() {

    }

    public static ApplicationComponent create(RunPainterApplication application) {
        return DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(application))
                .databaseModule(new DatabaseModule())
                .locationProviderModule(new LocationProviderModule())
                .build();
    }
}
