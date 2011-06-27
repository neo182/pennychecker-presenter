/**
 * BSD License
 * Copyright (c) David Peterson
 * All rights reserved.
 */
package com.pennychecker.presenter.javafx;

import com.pennychecker.eventbus.EventBus;
import com.pennychecker.presenter.BasicPresenter;

/**
 * 
 * @author David Peterson, refactored by Steffen Kaempke
 *
 * @param <D>
 */
public abstract class FxPresenter <D extends FxDisplay> extends BasicPresenter<D> {
	public FxPresenter(D display, EventBus eventBus) {
        super(display, eventBus);
    }
}
