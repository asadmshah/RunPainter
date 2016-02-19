package com.asadmshah.runpainter.screens.old_run;

import javax.inject.Inject;

public class OldRunScreenPresenter implements OldRunScreenContract.Presenter {

    private final OldRunScreenContract.View view;

    @Inject
    public OldRunScreenPresenter(OldRunScreenContract.View view) {
        this.view = view;
    }
}
