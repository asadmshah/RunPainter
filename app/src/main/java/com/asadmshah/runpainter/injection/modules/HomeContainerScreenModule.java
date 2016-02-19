package com.asadmshah.runpainter.injection.modules;

import com.asadmshah.runpainter.injection.scopes.ActivityScope;
import com.asadmshah.runpainter.screens.home_container.HomeContainerScreenContract;
import com.asadmshah.runpainter.screens.home_container.HomeContainerScreenPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class HomeContainerScreenModule {

    private final HomeContainerScreenContract.View view;

    public HomeContainerScreenModule(HomeContainerScreenContract.View view) {
        this.view = view;
    }

    @Provides
    @ActivityScope
    public HomeContainerScreenContract.View providesView() {
        return view;
    }

    @Provides
    @ActivityScope
    public HomeContainerScreenContract.Presenter providesPresenter(HomeContainerScreenPresenter presenter) {
        return presenter;
    }
}
