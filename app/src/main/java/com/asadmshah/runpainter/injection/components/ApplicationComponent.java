package com.asadmshah.runpainter.injection.components;

import com.asadmshah.runpainter.injection.modules.ApplicationModule;
import com.asadmshah.runpainter.injection.modules.DatabaseModule;
import com.asadmshah.runpainter.injection.modules.LocationProviderModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(
        modules = {
                ApplicationModule.class,
                DatabaseModule.class,
                LocationProviderModule.class
        }
)
public interface ApplicationComponent {
}
