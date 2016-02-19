package com.asadmshah.runpainter.screens.settings;

import android.os.Bundle;
import android.preference.PreferenceFragment;

import com.asadmshah.runpainter.RunPainterApplication;
import com.asadmshah.runpainter.injection.ComponentFactory;

import javax.inject.Inject;

public class SettingsScreenFragment extends PreferenceFragment implements SettingsScreenContract.View {

    @Inject SettingsScreenContract.Presenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ComponentFactory.create(RunPainterApplication.getComponent(getActivity()), this).inject(this);
    }
}
