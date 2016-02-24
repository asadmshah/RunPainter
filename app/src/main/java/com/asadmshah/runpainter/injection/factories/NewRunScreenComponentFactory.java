package com.asadmshah.runpainter.injection.factories;

import com.asadmshah.runpainter.injection.components.ApplicationComponent;
import com.asadmshah.runpainter.injection.components.DaggerNewRunScreenComponent;
import com.asadmshah.runpainter.injection.components.NewRunScreenComponent;
import com.asadmshah.runpainter.injection.modules.NewRunScreenModule;
import com.asadmshah.runpainter.screens.new_run.NewRunScreenContract;

public class NewRunScreenComponentFactory {

    private NewRunScreenComponentFactory() {

    }

    public static NewRunScreenComponent create(ApplicationComponent component, NewRunScreenContract.View view) {
        return DaggerNewRunScreenComponent.builder()
                .applicationComponent(component)
                .newRunScreenModule(new NewRunScreenModule(view))
                .build();
    }
}
