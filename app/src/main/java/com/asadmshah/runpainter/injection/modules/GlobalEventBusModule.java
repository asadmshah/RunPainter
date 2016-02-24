package com.asadmshah.runpainter.injection.modules;

import com.asadmshah.runpainter.eventbus.GlobalEventBus;
import com.asadmshah.runpainter.eventbus.GlobalEventBusImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class GlobalEventBusModule {

    @Provides
    @Singleton
    public GlobalEventBus providesGlobalEventBus() {
        return new GlobalEventBusImpl();
    }
}
