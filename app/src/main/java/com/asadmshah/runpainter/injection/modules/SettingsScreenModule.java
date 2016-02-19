package com.asadmshah.runpainter.injection.modules;

import com.asadmshah.runpainter.injection.scopes.FragmentScope;
import com.asadmshah.runpainter.screens.settings.SettingsScreenContract;
import com.asadmshah.runpainter.screens.settings.SettingsScreenPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class SettingsScreenModule {

    private final SettingsScreenContract.View view;

    public SettingsScreenModule(SettingsScreenContract.View view) {
        this.view = view;
    }

    @Provides
    @FragmentScope
    public SettingsScreenContract.View providesView() {
        return view;
    }

    @Provides
    @FragmentScope
    public SettingsScreenContract.Presenter providesPresenter(SettingsScreenPresenter presenter) {
        return presenter;
    }
}
