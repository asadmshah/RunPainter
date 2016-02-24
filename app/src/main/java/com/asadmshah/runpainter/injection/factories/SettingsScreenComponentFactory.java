package com.asadmshah.runpainter.injection.factories;

import com.asadmshah.runpainter.injection.components.ApplicationComponent;
import com.asadmshah.runpainter.injection.components.DaggerSettingsScreenComponent;
import com.asadmshah.runpainter.injection.components.SettingsScreenComponent;
import com.asadmshah.runpainter.injection.modules.SettingsScreenModule;
import com.asadmshah.runpainter.screens.settings.SettingsScreenContract;

public class SettingsScreenComponentFactory {

    private SettingsScreenComponentFactory() {

    }

    public static SettingsScreenComponent create(ApplicationComponent component, SettingsScreenContract.View view) {
        return DaggerSettingsScreenComponent.builder()
                .applicationComponent(component)
                .settingsScreenModule(new SettingsScreenModule(view))
                .build();
    }
}
