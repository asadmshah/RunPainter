package com.asadmshah.runpainter.injection.factories;

import com.asadmshah.runpainter.injection.components.ApplicationComponent;
import com.asadmshah.runpainter.injection.components.DaggerOldRunScreenComponent;
import com.asadmshah.runpainter.injection.components.OldRunScreenComponent;
import com.asadmshah.runpainter.injection.modules.OldRunScreenModule;
import com.asadmshah.runpainter.screens.old_run.OldRunScreenContract;

public class OldRunScreenComponentFactory {

    private OldRunScreenComponentFactory() {

    }

    public static OldRunScreenComponent create(ApplicationComponent component, OldRunScreenContract.View view) {
        return DaggerOldRunScreenComponent.builder()
                .applicationComponent(component)
                .oldRunScreenModule(new OldRunScreenModule(view))
                .build();
    }
}
