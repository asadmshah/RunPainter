package com.asadmshah.runpainter.injection.components;

import com.asadmshah.runpainter.injection.modules.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(
        modules = {
                ApplicationModule.class
        }
)
public interface ApplicationComponent {
}
