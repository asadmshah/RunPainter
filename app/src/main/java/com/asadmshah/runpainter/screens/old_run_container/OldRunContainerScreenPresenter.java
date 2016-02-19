package com.asadmshah.runpainter.screens.old_run_container;

import javax.inject.Inject;

public class OldRunContainerScreenPresenter implements OldRunContainerScreenContract.Presenter {

    private final OldRunContainerScreenContract.View view;

    @Inject
    public OldRunContainerScreenPresenter(OldRunContainerScreenContract.View view) {
        this.view = view;
    }
}
