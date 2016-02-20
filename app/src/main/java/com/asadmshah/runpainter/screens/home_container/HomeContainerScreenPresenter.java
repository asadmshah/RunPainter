package com.asadmshah.runpainter.screens.home_container;

import android.support.annotation.Nullable;

import com.asadmshah.runpainter.utils.Bundler;

import javax.inject.Inject;

public class HomeContainerScreenPresenter implements HomeContainerScreenContract.Presenter {

    private final HomeContainerScreenContract.View view;

    @Inject
    public HomeContainerScreenPresenter(HomeContainerScreenContract.View view) {
        this.view = view;
    }

    @Override
    public void onCreate(@Nullable Bundler bundler) {
        if (bundler == null) {
            view.showRunsListScreen();
        }
    }
}
