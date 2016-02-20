package com.asadmshah.runpainter.screens.home_container;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.asadmshah.runpainter.R;
import com.asadmshah.runpainter.RunPainterApplication;
import com.asadmshah.runpainter.injection.ComponentFactory;
import com.asadmshah.runpainter.screens.runs_list.RunsListScreenFragment;
import com.asadmshah.runpainter.utils.BundlerImpl;

import javax.inject.Inject;

public class HomeContainerScreenActivity extends AppCompatActivity implements HomeContainerScreenContract.View {

    @Inject HomeContainerScreenContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_container);

        ComponentFactory.create(RunPainterApplication.getComponent(this), this).inject(this);

        presenter.onCreate(savedInstanceState == null ? null : new BundlerImpl(savedInstanceState));
    }

    @Override
    public void showRunsListScreen() {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.runs_list_fragment, RunsListScreenFragment.newInstance())
                .commit();
    }
}
