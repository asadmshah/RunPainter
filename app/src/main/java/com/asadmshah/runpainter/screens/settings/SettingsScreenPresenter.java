package com.asadmshah.runpainter.screens.settings;

import javax.inject.Inject;

public class SettingsScreenPresenter implements SettingsScreenContract.Presenter {

    private final SettingsScreenContract.View view;

    @Inject
    public SettingsScreenPresenter(SettingsScreenContract.View view) {
        this.view = view;
    }
}
