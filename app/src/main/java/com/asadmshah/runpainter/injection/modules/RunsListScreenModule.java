package com.asadmshah.runpainter.injection.modules;

import com.asadmshah.runpainter.injection.scopes.FragmentScope;
import com.asadmshah.runpainter.screens.runs_list.RunsListScreenContract;
import com.asadmshah.runpainter.screens.runs_list.RunsListScreenPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class RunsListScreenModule {

    private final RunsListScreenContract.View view;

    public RunsListScreenModule(RunsListScreenContract.View view) {
        this.view = view;
    }

    @Provides
    @FragmentScope
    public RunsListScreenContract.View providesView() {
        return view;
    }

    @Provides
    @FragmentScope
    public RunsListScreenContract.Presenter providesPresenter(RunsListScreenPresenter presenter) {
        return presenter;
    }
}
