package com.asadmshah.runpainter.screens.home_container;

import android.support.annotation.Nullable;

import com.asadmshah.runpainter.utils.Bundler;

public interface HomeContainerScreenContract {

    interface View {

        void showRunsListScreen();
    }

    interface Presenter {

        void onCreate(@Nullable Bundler bundler);
    }

}
