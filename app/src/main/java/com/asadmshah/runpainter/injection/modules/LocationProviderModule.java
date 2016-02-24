package com.asadmshah.runpainter.injection.modules;

import android.content.Context;

import com.asadmshah.runpainter.location.LocationProvider;
import com.asadmshah.runpainter.location.LocationProviderImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class LocationProviderModule {

    @Provides
    @Singleton
    public LocationProvider providesLocationProvider(Context context) {
        return new LocationProviderImpl(context);
    }
}
