package com.asadmshah.runpainter.screens.runs_list;

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

public class RunsListScreenFragment extends Fragment implements RunsListScreenContract.View {

    @Inject RunsListScreenContract.Presenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ComponentFactory.create(RunPainterApplication.getComponent(getActivity()), this).inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_runs_list, container, false);
    }

    public static RunsListScreenFragment newInstance() {
        Bundle args = new Bundle();
        RunsListScreenFragment fragment = new RunsListScreenFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
