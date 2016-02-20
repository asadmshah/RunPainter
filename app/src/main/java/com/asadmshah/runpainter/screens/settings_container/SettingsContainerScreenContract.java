package com.asadmshah.runpainter.screens.settings_container;

import android.support.annotation.Nullable;

import com.asadmshah.runpainter.utils.Bundler;

public interface SettingsContainerScreenContract {

    interface View {

        void showSettingsScreen();
    }

    interface Presenter {

        void onCreate(@Nullable Bundler bundler);
    }
}
