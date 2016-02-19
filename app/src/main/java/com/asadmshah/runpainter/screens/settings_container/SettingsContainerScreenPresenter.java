package com.asadmshah.runpainter.screens.settings_container;

import javax.inject.Inject;

public class SettingsContainerScreenPresenter implements SettingsContainerScreenContract.Presenter {

    private final SettingsContainerScreenContract.View view;

    @Inject
    public SettingsContainerScreenPresenter(SettingsContainerScreenContract.View view) {
        this.view = view;
    }
}
