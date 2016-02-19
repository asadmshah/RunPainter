package com.asadmshah.runpainter.injection.modules;

import com.asadmshah.runpainter.injection.scopes.ActivityScope;
import com.asadmshah.runpainter.screens.old_run_container.OldRunContainerScreenContract;
import com.asadmshah.runpainter.screens.old_run_container.OldRunContainerScreenPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class OldRunContainerScreenModule {

    private final OldRunContainerScreenContract.View view;

    public OldRunContainerScreenModule(OldRunContainerScreenContract.View view) {
        this.view = view;
    }

    @Provides
    @ActivityScope
    public OldRunContainerScreenContract.View providesView() {
        return view;
    }

    @Provides
    @ActivityScope
    public OldRunContainerScreenContract.Presenter providesPresenter(OldRunContainerScreenPresenter presenter) {
        return presenter;
    }
}
