/**
 * BSD License
 * Copyright (c) David Peterson
 * All rights reserved.
 */
package com.pennychecker.presenter.wicket;

import org.apache.wicket.Component;

import com.pennychecker.presenter.Display;
import com.pennychecker.presenter.Presenter;
/**
 * 
 * @author David Peterson, refactored by Steffen Kaempke
 *
 * @param <P>
 */
public interface WicketDisplay<P extends Presenter> extends Display{
	Component asComponent();
	
	void setPresenter(P presenter);
}