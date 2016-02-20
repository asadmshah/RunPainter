package com.asadmshah.runpainter.screens.old_run_container;

import android.support.annotation.Nullable;

import com.asadmshah.runpainter.utils.Bundler;

public interface OldRunContainerScreenContract {

    interface View {

        void showOldRunScreen();
    }

    interface Presenter {

        void onCreate(@Nullable Bundler bundler);
    }
}
