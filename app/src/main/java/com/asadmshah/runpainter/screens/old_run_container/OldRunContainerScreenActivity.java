package com.asadmshah.runpainter.screens.old_run_container;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.asadmshah.runpainter.R;
import com.asadmshah.runpainter.RunPainterApplication;
import com.asadmshah.runpainter.injection.ComponentFactory;

import javax.inject.Inject;

public class OldRunContainerScreenActivity extends AppCompatActivity implements OldRunContainerScreenContract.View {

    @Inject OldRunContainerScreenContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_old_run_container);

        ComponentFactory.create(RunPainterApplication.getComponent(this), this).inject(this);
    }
}
