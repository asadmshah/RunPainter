package com.asadmshah.runpainter.injection.factories;

import com.asadmshah.runpainter.injection.components.ApplicationComponent;
import com.asadmshah.runpainter.injection.components.DaggerOldRunContainerScreenComponent;
import com.asadmshah.runpainter.injection.components.OldRunContainerScreenComponent;
import com.asadmshah.runpainter.injection.modules.OldRunContainerScreenModule;
import com.asadmshah.runpainter.screens.old_run_container.OldRunContainerScreenContract;

public class OldRunContainerScreenComponentFactory {

    private OldRunContainerScreenComponentFactory() {

    }

    public static OldRunContainerScreenComponent create(ApplicationComponent component, OldRunContainerScreenContract.View view) {
        return DaggerOldRunContainerScreenComponent.builder()
                .applicationComponent(component)
                .oldRunContainerScreenModule(new OldRunContainerScreenModule(view))
                .build();
    }
}
