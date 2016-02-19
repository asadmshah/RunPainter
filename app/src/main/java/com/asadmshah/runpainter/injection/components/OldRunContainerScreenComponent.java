package com.asadmshah.runpainter.injection.components;

import com.asadmshah.runpainter.injection.modules.OldRunContainerScreenModule;
import com.asadmshah.runpainter.injection.scopes.ActivityScope;
import com.asadmshah.runpainter.screens.old_run_container.OldRunContainerScreenActivity;

import dagger.Component;

@ActivityScope
@Component(
        dependencies = {
                ApplicationComponent.class
        },
        modules = {
                OldRunContainerScreenModule.class
        }
)
public interface OldRunContainerScreenComponent {
    void inject(OldRunContainerScreenActivity target);
}
