package com.asadmshah.runpainter.screens.settings_container;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.asadmshah.runpainter.RunPainterApplication;
import com.asadmshah.runpainter.injection.ComponentFactory;

import javax.inject.Inject;

public class SettingsContainerScreenActivity extends AppCompatActivity implements SettingsContainerScreenContract.View {

    @Inject SettingsContainerScreenContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ComponentFactory.create(RunPainterApplication.getComponent(this), this).inject(this);
    }
}
