/**
 * BSD License
 * Copyright (c) David Peterson
 * All rights reserved.
 */
package com.pennychecker.presenter.swing;

import com.pennychecker.eventbus.EventBus;
import com.pennychecker.presenter.BasicPresenter;

/**
 * 
 * @author David Peterson, refactored by Steffen Kaempke
 *
 */
public abstract class SwingPresenter <D extends SwingDisplay> extends BasicPresenter<D> {
	public SwingPresenter(D display, EventBus eventBus) {
        super(display, eventBus);
    }
}
