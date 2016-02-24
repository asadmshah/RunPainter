package com.asadmshah.runpainter.eventbus;

import com.asadmshah.runpainter.BuildConfig;

import org.greenrobot.eventbus.EventBus;

public class GlobalEventBusImpl implements GlobalEventBus {

    private final EventBus eventBus;

    public GlobalEventBusImpl() {
        eventBus = EventBus.builder()
                .logSubscriberExceptions(BuildConfig.DEBUG)
                .logNoSubscriberMessages(BuildConfig.DEBUG)
                .throwSubscriberException(BuildConfig.DEBUG)
                .strictMethodVerification(BuildConfig.DEBUG)
                .sendSubscriberExceptionEvent(BuildConfig.DEBUG)
                .sendNoSubscriberEvent(false)
                .build();
    }

    @Override
    public void register(Object target) {
        eventBus.register(target);
    }

    @Override
    public void unregister(Object target) {
        eventBus.unregister(target);
    }

    @Override
    public void post(Object event) {
        eventBus.post(event);
    }

    @Override
    public void postSticky(Object event) {
        eventBus.postSticky(event);
    }
}
