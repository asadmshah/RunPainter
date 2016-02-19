package com.asadmshah.runpainter.screens.new_run_container;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.asadmshah.runpainter.R;

public class NewRunContainerScreenActivity extends AppCompatActivity implements NewRunContainerScreenContract.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_run_container);
    }

}
