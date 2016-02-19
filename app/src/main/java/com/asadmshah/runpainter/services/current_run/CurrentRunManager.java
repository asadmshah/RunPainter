package com.asadmshah.runpainter.services.current_run;

public class CurrentRunManager implements CurrentRunContract.Manager {

    private final CurrentRunContract.Service service;

    public CurrentRunManager(CurrentRunContract.Service service) {
        this.service = service;
    }
}
