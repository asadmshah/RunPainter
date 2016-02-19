package com.asadmshah.runpainter.screens.new_run_container;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.asadmshah.runpainter.R;
import com.asadmshah.runpainter.RunPainterApplication;
import com.asadmshah.runpainter.injection.ComponentFactory;

import javax.inject.Inject;

public class NewRunContainerScreenActivity extends AppCompatActivity implements NewRunContainerScreenContract.View {

    @Inject NewRunContainerScreenContract.View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_run_container);

        ComponentFactory.create(RunPainterApplication.getComponent(this), this).inject(this);
    }

}
