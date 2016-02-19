package com.asadmshah.runpainter.screens.new_run;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.asadmshah.runpainter.R;
import com.asadmshah.runpainter.RunPainterApplication;
import com.asadmshah.runpainter.injection.ComponentFactory;

import javax.inject.Inject;

public class NewRunScreenFragment extends Fragment implements NewRunScreenContract.View {

    @Inject NewRunScreenContract.Presenter presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ComponentFactory.create(RunPainterApplication.getComponent(getActivity()), this).inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_new_run, container, false);
    }

    public static NewRunScreenFragment newInstance() {
        Bundle args = new Bundle();
        NewRunScreenFragment fragment = new NewRunScreenFragment();
        fragment.setArguments(args);
        return fragment;
    }

}
