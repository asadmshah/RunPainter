package com.asadmshah.runpainter.screens.runs_list;

import javax.inject.Inject;

public class RunsListScreenPresenter implements RunsListScreenContract.Presenter {

    private final RunsListScreenContract.View view;

    @Inject
    public RunsListScreenPresenter(RunsListScreenContract.View view) {
        this.view = view;
    }
}
