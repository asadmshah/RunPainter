package com.asadmshah.runpainter.injection.components;

import com.asadmshah.runpainter.injection.modules.NewRunScreenModule;
import com.asadmshah.runpainter.injection.scopes.FragmentScope;
import com.asadmshah.runpainter.screens.new_run.NewRunScreenFragment;

import dagger.Component;

@FragmentScope
@Component(
        dependencies = {
                ApplicationComponent.class
        },
        modules = {
                NewRunScreenModule.class
        }
)
public interface NewRunScreenComponent {
    void inject(NewRunScreenFragment target);
}
