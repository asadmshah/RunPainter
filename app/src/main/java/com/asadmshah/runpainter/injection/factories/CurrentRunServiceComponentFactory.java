package com.asadmshah.runpainter.injection.factories;

import com.asadmshah.runpainter.injection.components.ApplicationComponent;
import com.asadmshah.runpainter.injection.components.CurrentRunServiceComponent;
import com.asadmshah.runpainter.injection.components.DaggerCurrentRunServiceComponent;
import com.asadmshah.runpainter.injection.modules.CurrentRunServiceModule;
import com.asadmshah.runpainter.services.current_run.CurrentRunContract;

public class CurrentRunServiceComponentFactory {

    private CurrentRunServiceComponentFactory() {

    }

    public static CurrentRunServiceComponent create(ApplicationComponent component, CurrentRunContract.Service service) {
        return DaggerCurrentRunServiceComponent.builder()
                .applicationComponent(component)
                .currentRunServiceModule(new CurrentRunServiceModule(service))
                .build();
    }
}
