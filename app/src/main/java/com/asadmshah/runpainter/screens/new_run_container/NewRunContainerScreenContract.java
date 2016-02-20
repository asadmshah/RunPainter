package com.asadmshah.runpainter.screens.new_run_container;

import android.support.annotation.Nullable;

import com.asadmshah.runpainter.utils.Bundler;

public interface NewRunContainerScreenContract {

    interface View {

        void showNewRunScreen();
    }

    interface Presenter {

        void onCreate(@Nullable Bundler bundler);
    }

}
