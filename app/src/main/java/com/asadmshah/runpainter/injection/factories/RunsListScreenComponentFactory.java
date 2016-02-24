package com.asadmshah.runpainter.injection.factories;

import com.asadmshah.runpainter.injection.components.ApplicationComponent;
import com.asadmshah.runpainter.injection.components.DaggerRunsListScreenComponent;
import com.asadmshah.runpainter.injection.components.RunsListScreenComponent;
import com.asadmshah.runpainter.injection.modules.RunsListScreenModule;
import com.asadmshah.runpainter.screens.runs_list.RunsListScreenContract;

public class RunsListScreenComponentFactory {

    private RunsListScreenComponentFactory() {

    }

    public static RunsListScreenComponent create(ApplicationComponent component, RunsListScreenContract.View view) {
        return DaggerRunsListScreenComponent.builder()
                .applicationComponent(component)
                .runsListScreenModule(new RunsListScreenModule(view))
                .build();
    }
}
