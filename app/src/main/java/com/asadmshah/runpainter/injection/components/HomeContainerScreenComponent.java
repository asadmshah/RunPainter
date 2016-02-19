package com.asadmshah.runpainter.injection.components;

import com.asadmshah.runpainter.injection.modules.HomeContainerScreenModule;
import com.asadmshah.runpainter.injection.scopes.ActivityScope;
import com.asadmshah.runpainter.screens.home_container.HomeContainerScreenActivity;

import dagger.Component;

@ActivityScope
@Component(
        dependencies = {
                ApplicationComponent.class
        },
        modules = {
                HomeContainerScreenModule.class
        }
)
public interface HomeContainerScreenComponent {
    void inject(HomeContainerScreenActivity target);
}
