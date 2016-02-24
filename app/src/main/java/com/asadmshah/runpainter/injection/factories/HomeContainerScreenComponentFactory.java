package com.asadmshah.runpainter.injection.factories;

import com.asadmshah.runpainter.injection.components.ApplicationComponent;
import com.asadmshah.runpainter.injection.components.DaggerHomeContainerScreenComponent;
import com.asadmshah.runpainter.injection.components.HomeContainerScreenComponent;
import com.asadmshah.runpainter.injection.modules.HomeContainerScreenModule;
import com.asadmshah.runpainter.screens.home_container.HomeContainerScreenContract;

public class HomeContainerScreenComponentFactory {

    private HomeContainerScreenComponentFactory() {

    }

    public static HomeContainerScreenComponent create(ApplicationComponent component, HomeContainerScreenContract.View view) {
        return DaggerHomeContainerScreenComponent.builder()
                .applicationComponent(component)
                .homeContainerScreenModule(new HomeContainerScreenModule(view))
                .build();
    }
}
