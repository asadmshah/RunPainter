package com.asadmshah.runpainter.screens.old_run_container;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.asadmshah.runpainter.R;

public class OldRunContainerScreenActivity extends AppCompatActivity implements OldRunContainerScreenContract.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_old_run_container);
    }
}
