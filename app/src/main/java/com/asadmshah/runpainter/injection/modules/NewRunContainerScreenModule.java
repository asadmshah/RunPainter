package com.asadmshah.runpainter.injection.modules;

import com.asadmshah.runpainter.injection.scopes.ActivityScope;
import com.asadmshah.runpainter.screens.new_run_container.NewRunContainerScreenContract;
import com.asadmshah.runpainter.screens.new_run_container.NewRunContainerScreenPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class NewRunContainerScreenModule {

    private final NewRunContainerScreenContract.View view;

    public NewRunContainerScreenModule(NewRunContainerScreenContract.View view) {
        this.view = view;
    }

    @Provides
    @ActivityScope
    public NewRunContainerScreenContract.View providesView() {
        return view;
    }

    @Provides
    @ActivityScope
    public NewRunContainerScreenContract.Presenter providesPresenter(NewRunContainerScreenPresenter presenter) {
        return presenter;
    }
}
