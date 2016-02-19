package com.asadmshah.runpainter.injection.components;

import com.asadmshah.runpainter.injection.modules.SettingsContainerScreenModule;
import com.asadmshah.runpainter.injection.scopes.ActivityScope;
import com.asadmshah.runpainter.screens.settings_container.SettingsContainerScreenActivity;

import dagger.Component;

@ActivityScope
@Component(
        dependencies = {
                ApplicationComponent.class
        },
        modules = {
                SettingsContainerScreenModule.class
        }
)
public interface SettingsContainerScreenComponent {
    void inject(SettingsContainerScreenActivity target);
}
