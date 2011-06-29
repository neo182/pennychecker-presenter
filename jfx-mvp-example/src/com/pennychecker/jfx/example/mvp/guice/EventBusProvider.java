/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pennychecker.jfx.example.mvp.guice;

import com.google.inject.Provider;
import com.pennychecker.eventbus.EventBus;
import com.pennychecker.presenter.event.DefaultEventBus;


/**
 *
 * @author sk
 */
public class EventBusProvider implements Provider<EventBus> {

    public EventBus get() {
        return new DefaultEventBus();
    }
}
