/**
 * BSD License
 * Copyright (c) David Peterson
 * All rights reserved.
 */
package com.pennychecker.presenter.swing;

import javax.swing.JComponent;

/**
 * 
 * @author David Peterson, refactored by Steffen Kaempke
 *
 */
public interface SwingContainerDisplay extends SwingDisplay {
	/**
    *
    * @param component
    */
   void showComponent(JComponent component);
   
   void addComponent(JComponent component);
   
   void removeComponent(JComponent component);
}
