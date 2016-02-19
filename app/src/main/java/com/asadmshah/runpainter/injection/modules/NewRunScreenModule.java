package com.asadmshah.runpainter.injection.modules;

import com.asadmshah.runpainter.injection.scopes.FragmentScope;
import com.asadmshah.runpainter.screens.new_run.NewRunScreenContract;
import com.asadmshah.runpainter.screens.new_run.NewRunScreenPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class NewRunScreenModule {

    private final NewRunScreenContract.View view;

    public NewRunScreenModule(NewRunScreenContract.View view) {
        this.view = view;
    }

    @Provides
    @FragmentScope
    public NewRunScreenContract.View providesView() {
        return view;
    }

    @Provides
    @FragmentScope
    public NewRunScreenContract.Presenter providesPresenter(NewRunScreenPresenter presenter) {
        return presenter;
    }

}
