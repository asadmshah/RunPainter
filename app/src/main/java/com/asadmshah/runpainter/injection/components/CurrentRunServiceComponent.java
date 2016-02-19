package com.asadmshah.runpainter.injection.components;

import com.asadmshah.runpainter.injection.modules.CurrentRunServiceModule;
import com.asadmshah.runpainter.injection.scopes.ServiceScope;
import com.asadmshah.runpainter.services.current_run.CurrentRunService;

import dagger.Component;

@ServiceScope
@Component(
        dependencies = {
                ApplicationComponent.class
        },
        modules = {
                CurrentRunServiceModule.class
        }
)
public interface CurrentRunServiceComponent {
    void inject(CurrentRunService target);
}
