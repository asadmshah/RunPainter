package com.asadmshah.runpainter.injection.modules;

import com.asadmshah.runpainter.injection.scopes.ActivityScope;
import com.asadmshah.runpainter.screens.settings_container.SettingsContainerScreenContract;
import com.asadmshah.runpainter.screens.settings_container.SettingsContainerScreenPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class SettingsContainerScreenModule {

    private final SettingsContainerScreenContract.View view;

    public SettingsContainerScreenModule(SettingsContainerScreenContract.View view) {
        this.view = view;
    }

    @Provides
    @ActivityScope
    public SettingsContainerScreenContract.View providesView() {
        return view;
    }

    @Provides
    @ActivityScope
    public SettingsContainerScreenContract.Presenter providesPresenter(SettingsContainerScreenPresenter presenter) {
        return presenter;
    }
}
