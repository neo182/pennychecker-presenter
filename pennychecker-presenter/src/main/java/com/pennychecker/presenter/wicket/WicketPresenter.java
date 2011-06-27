/**
 * BSD License
 * Copyright (c) David Peterson
 * All rights reserved.
 */
package com.pennychecker.presenter.wicket;

import java.io.Serializable;

import com.pennychecker.eventbus.EventBus;
import com.pennychecker.presenter.BasicPresenter;
/**
 * 
 * @author David Peterson, refactored by Steffen Kaempke
 *
 * @param <P>
 */
public abstract class WicketPresenter <D extends WicketDisplay<?>> extends BasicPresenter<D> implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5365905895970809426L;

	public WicketPresenter(D display, EventBus eventBus) {
        super(display, eventBus);
    }
}
