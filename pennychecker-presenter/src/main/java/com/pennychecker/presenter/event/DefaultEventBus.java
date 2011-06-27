/**
 * BSD License
 * Copyright (c) David Peterson
 * All rights reserved.
 */
package com.pennychecker.presenter.event;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.pennychecker.eventbus.EventBus;
import com.pennychecker.eventbus.HandlerManager;

@Singleton
public class DefaultEventBus extends HandlerManager implements EventBus {

    @Inject
    public DefaultEventBus() {
        super(null);
    }
}
