package com.asadmshah.runpainter.injection.components;

import com.asadmshah.runpainter.injection.modules.OldRunScreenModule;
import com.asadmshah.runpainter.injection.scopes.FragmentScope;
import com.asadmshah.runpainter.screens.old_run.OldRunScreenFragment;

import dagger.Component;

@FragmentScope
@Component(
        dependencies = {
                ApplicationComponent.class
        },
        modules = {
                OldRunScreenModule.class
        }
)
public interface OldRunScreenComponent {
    void inject(OldRunScreenFragment target);
}
