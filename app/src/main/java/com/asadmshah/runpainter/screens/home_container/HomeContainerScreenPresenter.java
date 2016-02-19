package com.asadmshah.runpainter.screens.home_container;

import javax.inject.Inject;

public class HomeContainerScreenPresenter implements HomeContainerScreenContract.Presenter {

    private final HomeContainerScreenContract.View view;

    @Inject
    public HomeContainerScreenPresenter(HomeContainerScreenContract.View view) {
        this.view = view;
    }
}
