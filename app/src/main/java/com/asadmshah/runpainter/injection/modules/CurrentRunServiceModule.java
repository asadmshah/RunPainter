package com.asadmshah.runpainter.injection.modules;

import com.asadmshah.runpainter.injection.scopes.ServiceScope;
import com.asadmshah.runpainter.services.current_run.CurrentRunContract;
import com.asadmshah.runpainter.services.current_run.CurrentRunManager;

import dagger.Module;
import dagger.Provides;

@Module
public class CurrentRunServiceModule {

    private final CurrentRunContract.Service service;

    public CurrentRunServiceModule(CurrentRunContract.Service service) {
        this.service = service;
    }

    @Provides
    @ServiceScope
    public CurrentRunContract.Service providesService() {
        return service;
    }

    @Provides
    @ServiceScope
    public CurrentRunContract.Manager providesManager(CurrentRunManager manager) {
        return manager;
    }
}
