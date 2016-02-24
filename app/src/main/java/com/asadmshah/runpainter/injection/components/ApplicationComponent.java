package com.asadmshah.runpainter.injection.components;

import com.asadmshah.runpainter.database.Database;
import com.asadmshah.runpainter.eventbus.GlobalEventBus;
import com.asadmshah.runpainter.injection.modules.ApplicationModule;
import com.asadmshah.runpainter.injection.modules.DatabaseModule;
import com.asadmshah.runpainter.injection.modules.GlobalEventBusModule;
import com.asadmshah.runpainter.injection.modules.LocationProviderModule;
import com.asadmshah.runpainter.location.LocationProvider;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(
        modules = {
                ApplicationModule.class,
                DatabaseModule.class,
                LocationProviderModule.class,
                GlobalEventBusModule.class
        }
)
public interface ApplicationComponent {
    Database database();
    LocationProvider locationProvider();
    GlobalEventBus globalEventBus();
}
