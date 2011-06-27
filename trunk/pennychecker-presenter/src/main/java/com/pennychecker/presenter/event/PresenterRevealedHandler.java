/**
 * BSD License
 * Copyright (c) David Peterson
 * All rights reserved.
 */
package com.pennychecker.presenter.event;

import com.pennychecker.eventbus.EventHandler;

public interface PresenterRevealedHandler extends EventHandler{
	void onPresenterRevealed(PresenterRevealedEvent event);
}
