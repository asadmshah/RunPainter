package com.asadmshah.runpainter.injection.components;

import com.asadmshah.runpainter.injection.modules.RunsListScreenModule;
import com.asadmshah.runpainter.injection.scopes.FragmentScope;
import com.asadmshah.runpainter.screens.runs_list.RunsListScreenFragment;

import dagger.Component;

@FragmentScope
@Component(
        dependencies = {
                ApplicationComponent.class
        },
        modules = {
                RunsListScreenModule.class
        }
)
public interface RunsListScreenComponent {
    void inject(RunsListScreenFragment target);
}
