package com.asadmshah.runpainter.injection.factories;

import com.asadmshah.runpainter.injection.components.ApplicationComponent;
import com.asadmshah.runpainter.injection.components.DaggerSettingsContainerScreenComponent;
import com.asadmshah.runpainter.injection.components.SettingsContainerScreenComponent;
import com.asadmshah.runpainter.injection.modules.SettingsContainerScreenModule;
import com.asadmshah.runpainter.screens.settings_container.SettingsContainerScreenContract;

public class SettingsContainerScreenComponentFactory {

    private SettingsContainerScreenComponentFactory() {

    }

    public static SettingsContainerScreenComponent create(ApplicationComponent component, SettingsContainerScreenContract.View view) {
        return DaggerSettingsContainerScreenComponent.builder()
                .applicationComponent(component)
                .settingsContainerScreenModule(new SettingsContainerScreenModule(view))
                .build();
    }
}
