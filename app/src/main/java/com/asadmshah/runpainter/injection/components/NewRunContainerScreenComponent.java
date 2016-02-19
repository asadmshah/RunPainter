package com.asadmshah.runpainter.injection.components;

import com.asadmshah.runpainter.injection.modules.NewRunContainerScreenModule;
import com.asadmshah.runpainter.injection.scopes.ActivityScope;
import com.asadmshah.runpainter.screens.new_run_container.NewRunContainerScreenActivity;

import dagger.Component;

@ActivityScope
@Component(
        dependencies = {
                ApplicationComponent.class
        },
        modules = {
                NewRunContainerScreenModule.class
        }
)
public interface NewRunContainerScreenComponent {
    void inject(NewRunContainerScreenActivity target);
}
