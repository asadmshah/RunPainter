package com.asadmshah.runpainter.screens.settings_container;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.asadmshah.runpainter.R;
import com.asadmshah.runpainter.RunPainterApplication;
import com.asadmshah.runpainter.injection.ComponentFactory;
import com.asadmshah.runpainter.screens.settings.SettingsScreenFragment;

import javax.inject.Inject;

public class SettingsContainerScreenActivity extends AppCompatActivity implements SettingsContainerScreenContract.View {

    @Inject SettingsContainerScreenContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ComponentFactory.create(RunPainterApplication.getComponent(this), this).inject(this);
    }

    @Override
    public void showSettingsScreen() {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.settings_fragment, SettingsScreenFragment.newInstance())
                .commit();
    }
}
