package com.asadmshah.runpainter.screens.new_run;

import javax.inject.Inject;

public class NewRunScreenPresenter implements NewRunScreenContract.Presenter {

    private final NewRunScreenContract.View view;

    @Inject
    public NewRunScreenPresenter(NewRunScreenContract.View view) {
        this.view = view;
    }
}
