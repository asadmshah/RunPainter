package com.asadmshah.runpainter.screens.old_run_container;

import android.support.annotation.Nullable;

import com.asadmshah.runpainter.utils.Bundler;

import javax.inject.Inject;

public class OldRunContainerScreenPresenter implements OldRunContainerScreenContract.Presenter {

    private final OldRunContainerScreenContract.View view;

    @Inject
    public OldRunContainerScreenPresenter(OldRunContainerScreenContract.View view) {
        this.view = view;
    }

    @Override
    public void onCreate(@Nullable Bundler bundler) {
        if (bundler == null) {
            view.showOldRunScreen();
        }
    }
}
