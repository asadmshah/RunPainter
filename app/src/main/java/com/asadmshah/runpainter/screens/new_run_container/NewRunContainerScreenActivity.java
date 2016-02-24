package com.asadmshah.runpainter.screens.new_run_container;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.asadmshah.runpainter.R;
import com.asadmshah.runpainter.RunPainterApplication;
import com.asadmshah.runpainter.injection.factories.NewRunContainerScreenComponentFactory;
import com.asadmshah.runpainter.screens.new_run.NewRunScreenFragment;
import com.asadmshah.runpainter.utils.BundlerImpl;

import javax.inject.Inject;

public class NewRunContainerScreenActivity extends AppCompatActivity implements NewRunContainerScreenContract.View {

    @Inject NewRunContainerScreenContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_run_container);

        NewRunContainerScreenComponentFactory.create(RunPainterApplication.getComponent(this), this).inject(this);

        presenter.onCreate(savedInstanceState == null ? null : new BundlerImpl(savedInstanceState));
    }

    @Override
    public void showNewRunScreen() {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.new_run_fragment, NewRunScreenFragment.newInstance())
                .commit();
    }
}
