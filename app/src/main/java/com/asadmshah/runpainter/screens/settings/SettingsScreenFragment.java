package com.asadmshah.runpainter.screens.settings;

import android.os.Bundle;
import android.support.v7.preference.PreferenceFragmentCompat;

import com.asadmshah.runpainter.RunPainterApplication;
import com.asadmshah.runpainter.injection.ComponentFactory;

import javax.inject.Inject;

public class SettingsScreenFragment extends PreferenceFragmentCompat implements SettingsScreenContract.View {

    @Inject SettingsScreenContract.Presenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ComponentFactory.create(RunPainterApplication.getComponent(getActivity()), this).inject(this);
    }

    @Override
    public void onCreatePreferences(Bundle bundle, String s) {

    }

    public static SettingsScreenFragment newInstance() {
        Bundle args = new Bundle();
        SettingsScreenFragment fragment = new SettingsScreenFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
