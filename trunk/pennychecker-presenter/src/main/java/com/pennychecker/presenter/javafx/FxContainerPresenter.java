/**
 * BSD License
 * Copyright (c) David Peterson
 * All rights reserved.
 */
package com.pennychecker.presenter.javafx;

import java.util.Collections;
import java.util.List;

import com.pennychecker.eventbus.EventBus;
import com.pennychecker.presenter.event.PresenterRevealedEvent;
import com.pennychecker.presenter.event.PresenterRevealedHandler;

public abstract class FxContainerPresenter<T extends FxContainerDisplay> extends FxPresenter<T> {
	private final List<FxPresenter<?>> presenters;
	private FxPresenter<?> currentPresenter;

	/**
	 * @author David Peterson, refactored by Steffen Kaempke
	 * @param display
	 * @param eventBus
	 * @param presenters
	 */
	public FxContainerPresenter(T display, EventBus eventBus, FxPresenter<?>... presenters) {
		super(display, eventBus);
		this.presenters = new java.util.ArrayList<FxPresenter<?>>();
		Collections.addAll(this.presenters, presenters);
	}

	/**
	 * Adds the presenter, if the current presenter is unbound.
	 * 
	 * @param presenter
	 *            The presenter to add.
	 * @return If added, returns <code>true</code>.
	 */
	protected boolean addPresenter(FxPresenter<?> presenter) {
		if (!isBound()) {
			presenters.add(presenter);
			return true;
		}
		return false;
	}

	@Override
	protected void onBind() {

		registerHandler(eventBus.addHandler(PresenterRevealedEvent.getType(), new PresenterRevealedHandler() {

			public void onPresenterRevealed(PresenterRevealedEvent event) {
				if (presenters.contains(event.getPresenter())) {
					showPresenter((FxPresenter<?>) event.getPresenter());
					revealDisplay();
				}
			}
		}));
	}

	@Override
	protected void onUnbind() {
		currentPresenter = null;
	}

	/**
	 * 
	 * @return
	 */
	protected FxPresenter<?> getCurrentPresenter() {
		return currentPresenter;
	}

	/**
	 * 
	 * @param presenter
	 * @return
	 */
	protected int indexOf(FxPresenter<?> presenter) {
		return presenters.indexOf(presenter);
	}

	/**
	 * 
	 * @param presenter
	 */
	protected void showPresenter(FxPresenter<?> presenter) {
		if (indexOf(presenter) >= 0) {
			currentPresenter = presenter;
			display.showParent(presenter.getDisplay().asParent());
		}
	}

}
