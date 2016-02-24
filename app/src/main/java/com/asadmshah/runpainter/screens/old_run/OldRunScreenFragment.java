package com.asadmshah.runpainter.screens.old_run;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.asadmshah.runpainter.R;
import com.asadmshah.runpainter.RunPainterApplication;
import com.asadmshah.runpainter.injection.factories.OldRunScreenComponentFactory;

import javax.inject.Inject;

public class OldRunScreenFragment extends Fragment implements OldRunScreenContract.View {

    @Inject OldRunScreenContract.Presenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        OldRunScreenComponentFactory.create(RunPainterApplication.getComponent(getActivity()), this).inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_old_run, container, false);
    }

    public static OldRunScreenFragment newInstance() {
        Bundle args = new Bundle();
        OldRunScreenFragment fragment = new OldRunScreenFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
