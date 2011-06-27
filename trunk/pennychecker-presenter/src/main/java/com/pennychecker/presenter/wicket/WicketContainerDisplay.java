/**
 * BSD License
 * Copyright (c) David Peterson
 * All rights reserved.
 */
package com.pennychecker.presenter.wicket;

import org.apache.wicket.Component;

import com.pennychecker.presenter.Presenter;
/**
 * 
 * @author David Peterson, refactored by Steffen Kaempke
 *
 * @param <P>
 */
public interface WicketContainerDisplay<P extends Presenter> extends WicketDisplay<P> {
	/**
    *
    * @param component
    */
   void showComponent(Component component);
   
   void addComponent(Component component);
   
   void removeComponent(Component component);
}
