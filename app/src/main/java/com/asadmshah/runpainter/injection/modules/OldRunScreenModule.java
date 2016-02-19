package com.asadmshah.runpainter.injection.modules;

import com.asadmshah.runpainter.injection.scopes.FragmentScope;
import com.asadmshah.runpainter.screens.old_run.OldRunScreenContract;
import com.asadmshah.runpainter.screens.old_run.OldRunScreenPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class OldRunScreenModule {

    private final OldRunScreenContract.View view;

    public OldRunScreenModule(OldRunScreenContract.View view) {
        this.view = view;
    }

    @Provides
    @FragmentScope
    public OldRunScreenContract.View providesView() {
        return view;
    }

    @Provides
    @FragmentScope
    public OldRunScreenContract.Presenter providesPresenter(OldRunScreenPresenter presenter) {
        return presenter;
    }
}
