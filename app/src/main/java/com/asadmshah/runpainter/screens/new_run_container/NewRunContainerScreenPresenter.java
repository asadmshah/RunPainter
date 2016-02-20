package com.asadmshah.runpainter.screens.new_run_container;

import android.support.annotation.Nullable;

import com.asadmshah.runpainter.utils.Bundler;

import javax.inject.Inject;

public class NewRunContainerScreenPresenter implements NewRunContainerScreenContract.Presenter {

    private final NewRunContainerScreenContract.View view;

    @Inject
    public NewRunContainerScreenPresenter(NewRunContainerScreenContract.View view) {
        this.view = view;
    }

    @Override
    public void onCreate(@Nullable Bundler bundler) {
        if (bundler == null) {
            view.showNewRunScreen();
        }
    }
}
