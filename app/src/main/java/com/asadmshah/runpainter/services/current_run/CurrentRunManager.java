package com.asadmshah.runpainter.services.current_run;

import javax.inject.Inject;

public class CurrentRunManager implements CurrentRunContract.Manager {

    private final CurrentRunContract.Service service;

    @Inject
    public CurrentRunManager(CurrentRunContract.Service service) {
        this.service = service;
    }
}
