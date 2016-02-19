package com.asadmshah.runpainter.screens.home_container;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.asadmshah.runpainter.R;

public class HomeContainerScreenActivity extends AppCompatActivity implements HomeContainerScreenContract.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_container);
    }

}
