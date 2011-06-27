/**
 * BSD License
 * Copyright (c) David Peterson
 * All rights reserved.
 */
package com.pennychecker.presenter.javafx;

import javafx.scene.Parent;

/**
 * 
 * @author David Peterson, refactored by Steffen Kaempke
 *
 */
public interface FxContainerDisplay extends FxDisplay {
	/**
	 * 
	 * @param component
	 */
	void showParent(Parent parent);

	void addParent(Parent parent);

	void removeParent(Parent parent);
}
