/**
 * BSD License
 * Copyright (c) David Peterson
 * All rights reserved.
 */
package com.pennychecker.presenter.wicket;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import com.pennychecker.eventbus.EventBus;
import com.pennychecker.presenter.Presenter;
import com.pennychecker.presenter.event.PresenterRevealedEvent;
import com.pennychecker.presenter.event.PresenterRevealedHandler;
/**
 * 
 * @author David Peterson, refactored by Steffen Kaempke
 *
 * @param <P>
 */
public abstract class WicketContainerPresenter <T extends WicketContainerDisplay<? extends Presenter>> extends WicketPresenter<T> implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2329700059290598711L;
	private final List<WicketPresenter<?>> presenters;
    private WicketPresenter<?> currentPresenter;

    /**
     *
     * @param display
     * @param eventBus
     * @param presenters
     */
    public WicketContainerPresenter(T display, EventBus eventBus,
    		WicketPresenter<?>... presenters) {
        super(display, eventBus);
        this.presenters = new java.util.ArrayList<WicketPresenter<?>>();
        Collections.addAll(this.presenters, presenters);
    }

    /**
     * Adds the presenter, if the current presenter is unbound.
     * 
     * @param presenter
     *            The presenter to add.
     * @return If added, returns <code>true</code>.
     */
    protected boolean addPresenter(WicketPresenter<?> presenter) {
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
                    showPresenter((WicketPresenter<?>) event.getPresenter());
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
    protected WicketPresenter<?> getCurrentPresenter() {
        return currentPresenter;
    }

    /**
     *
     * @param presenter
     * @return
     */
    protected int indexOf(WicketPresenter<?> presenter) {
        return presenters.indexOf(presenter);
    }

    /**
     *
     * @param presenter
     */
    protected void showPresenter(WicketPresenter<?> presenter) {
        if (indexOf(presenter) >= 0) {
            currentPresenter = presenter;
            display.showComponent(presenter.getDisplay().asComponent());
        }
    }
}
