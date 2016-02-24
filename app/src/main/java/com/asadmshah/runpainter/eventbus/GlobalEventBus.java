package com.asadmshah.runpainter.eventbus;

public interface GlobalEventBus {

    void register(Object target);

    void unregister(Object target);

    void post(Object event);

    void postSticky(Object event);
}
