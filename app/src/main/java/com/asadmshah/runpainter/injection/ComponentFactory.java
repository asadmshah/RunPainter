package com.asadmshah.runpainter.injection;

import com.asadmshah.runpainter.RunPainterApplication;
import com.asadmshah.runpainter.injection.components.ApplicationComponent;
import com.asadmshah.runpainter.injection.components.CurrentRunServiceComponent;
import com.asadmshah.runpainter.injection.components.DaggerApplicationComponent;
import com.asadmshah.runpainter.injection.components.DaggerCurrentRunServiceComponent;
import com.asadmshah.runpainter.injection.components.DaggerHomeContainerScreenComponent;
import com.asadmshah.runpainter.injection.components.DaggerNewRunContainerScreenComponent;
import com.asadmshah.runpainter.injection.components.DaggerNewRunScreenComponent;
import com.asadmshah.runpainter.injection.components.DaggerOldRunContainerScreenComponent;
import com.asadmshah.runpainter.injection.components.DaggerOldRunScreenComponent;
import com.asadmshah.runpainter.injection.components.DaggerRunsListScreenComponent;
import com.asadmshah.runpainter.injection.components.DaggerSettingsContainerScreenComponent;
import com.asadmshah.runpainter.injection.components.DaggerSettingsScreenComponent;
import com.asadmshah.runpainter.injection.components.HomeContainerScreenComponent;
import com.asadmshah.runpainter.injection.components.NewRunContainerScreenComponent;
import com.asadmshah.runpainter.injection.components.NewRunScreenComponent;
import com.asadmshah.runpainter.injection.components.OldRunContainerScreenComponent;
import com.asadmshah.runpainter.injection.components.OldRunScreenComponent;
import com.asadmshah.runpainter.injection.components.RunsListScreenComponent;
import com.asadmshah.runpainter.injection.components.SettingsContainerScreenComponent;
import com.asadmshah.runpainter.injection.components.SettingsScreenComponent;
import com.asadmshah.runpainter.injection.modules.ApplicationModule;
import com.asadmshah.runpainter.injection.modules.CurrentRunServiceModule;
import com.asadmshah.runpainter.injection.modules.HomeContainerScreenModule;
import com.asadmshah.runpainter.injection.modules.NewRunContainerScreenModule;
import com.asadmshah.runpainter.injection.modules.NewRunScreenModule;
import com.asadmshah.runpainter.injection.modules.OldRunContainerScreenModule;
import com.asadmshah.runpainter.injection.modules.OldRunScreenModule;
import com.asadmshah.runpainter.injection.modules.RunsListScreenModule;
import com.asadmshah.runpainter.injection.modules.SettingsContainerScreenModule;
import com.asadmshah.runpainter.injection.modules.SettingsScreenModule;
import com.asadmshah.runpainter.screens.home_container.HomeContainerScreenContract;
import com.asadmshah.runpainter.screens.new_run.NewRunScreenContract;
import com.asadmshah.runpainter.screens.new_run_container.NewRunContainerScreenContract;
import com.asadmshah.runpainter.screens.old_run.OldRunScreenContract;
import com.asadmshah.runpainter.screens.old_run_container.OldRunContainerScreenContract;
import com.asadmshah.runpainter.screens.runs_list.RunsListScreenContract;
import com.asadmshah.runpainter.screens.settings.SettingsScreenContract;
import com.asadmshah.runpainter.screens.settings_container.SettingsContainerScreenContract;
import com.asadmshah.runpainter.services.current_run.CurrentRunContract;

public class ComponentFactory {

    private ComponentFactory() {

    }

    public static ApplicationComponent create(RunPainterApplication application) {
        return DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(application))
                .build();
    }

    public static HomeContainerScreenComponent create(ApplicationComponent component, HomeContainerScreenContract.View view) {
        return DaggerHomeContainerScreenComponent.builder()
                .applicationComponent(component)
                .homeContainerScreenModule(new HomeContainerScreenModule(view))
                .build();
    }

    public static NewRunScreenComponent create(ApplicationComponent component, NewRunScreenContract.View view) {
        return DaggerNewRunScreenComponent.builder()
                .applicationComponent(component)
                .newRunScreenModule(new NewRunScreenModule(view))
                .build();
    }

    public static NewRunContainerScreenComponent create(ApplicationComponent component, NewRunContainerScreenContract.View view) {
        return DaggerNewRunContainerScreenComponent.builder()
                .applicationComponent(component)
                .newRunContainerScreenModule(new NewRunContainerScreenModule(view))
                .build();
    }

    public static OldRunScreenComponent create(ApplicationComponent component, OldRunScreenContract.View view) {
        return DaggerOldRunScreenComponent.builder()
                .applicationComponent(component)
                .oldRunScreenModule(new OldRunScreenModule(view))
                .build();
    }

    public static OldRunContainerScreenComponent create(ApplicationComponent component, OldRunContainerScreenContract.View view) {
        return DaggerOldRunContainerScreenComponent.builder()
                .applicationComponent(component)
                .oldRunContainerScreenModule(new OldRunContainerScreenModule(view))
                .build();
    }

    public static RunsListScreenComponent create(ApplicationComponent component, RunsListScreenContract.View view) {
        return DaggerRunsListScreenComponent.builder()
                .applicationComponent(component)
                .runsListScreenModule(new RunsListScreenModule(view))
                .build();
    }

    public static SettingsScreenComponent create(ApplicationComponent component, SettingsScreenContract.View view) {
        return DaggerSettingsScreenComponent.builder()
                .applicationComponent(component)
                .settingsScreenModule(new SettingsScreenModule(view))
                .build();
    }

    public static SettingsContainerScreenComponent create(ApplicationComponent component, SettingsContainerScreenContract.View view) {
        return DaggerSettingsContainerScreenComponent.builder()
                .applicationComponent(component)
                .settingsContainerScreenModule(new SettingsContainerScreenModule(view))
                .build();
    }

    public static CurrentRunServiceComponent create(ApplicationComponent component, CurrentRunContract.Service service) {
        return DaggerCurrentRunServiceComponent.builder()
                .applicationComponent(component)
                .currentRunServiceModule(new CurrentRunServiceModule(service))
                .build();
    }

}
