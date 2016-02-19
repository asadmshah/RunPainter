package com.asadmshah.runpainter.injection.components;

import com.asadmshah.runpainter.injection.modules.SettingsScreenModule;
import com.asadmshah.runpainter.injection.scopes.FragmentScope;
import com.asadmshah.runpainter.screens.settings.SettingsScreenFragment;

import dagger.Component;

@FragmentScope
@Component(
        dependencies = {
                ApplicationComponent.class
        },
        modules = {
                SettingsScreenModule.class
        }
)
public interface SettingsScreenComponent {
    void inject(SettingsScreenFragment target);
}
