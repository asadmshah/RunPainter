package com.asadmshah.runpainter.injection.factories;

import com.asadmshah.runpainter.injection.components.ApplicationComponent;
import com.asadmshah.runpainter.injection.components.DaggerNewRunContainerScreenComponent;
import com.asadmshah.runpainter.injection.components.NewRunContainerScreenComponent;
import com.asadmshah.runpainter.injection.modules.NewRunContainerScreenModule;
import com.asadmshah.runpainter.screens.new_run_container.NewRunContainerScreenContract;

public class NewRunContainerScreenComponentFactory {

    private NewRunContainerScreenComponentFactory() {

    }

    public static NewRunContainerScreenComponent create(ApplicationComponent component, NewRunContainerScreenContract.View view) {
        return DaggerNewRunContainerScreenComponent.builder()
                .applicationComponent(component)
                .newRunContainerScreenModule(new NewRunContainerScreenModule(view))
                .build();
    }
}
