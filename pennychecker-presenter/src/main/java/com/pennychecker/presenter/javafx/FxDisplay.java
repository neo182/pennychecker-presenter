/**
 * BSD License
 * Copyright (c) David Peterson
 * All rights reserved.
 */
package com.pennychecker.presenter.javafx;

import javafx.scene.Parent;

import com.pennychecker.presenter.Display;

/**
 * 
 * @author David Peterson, refactored by Steffen Kaempke
 *
 */
public interface FxDisplay extends Display{
	Parent asParent();
}
