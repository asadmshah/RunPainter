package com.asadmshah.runpainter.screens.new_run_container;

import javax.inject.Inject;

public class NewRunContainerScreenPresenter implements NewRunContainerScreenContract.Presenter {

    private final NewRunContainerScreenContract.View view;

    @Inject
    public NewRunContainerScreenPresenter(NewRunContainerScreenContract.View view) {
        this.view = view;
    }
}
