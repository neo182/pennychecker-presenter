/**
 * Copyright [2011] Steffen Kämpke
 * mailto: sk@pennychecker.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.pennychecker.wicketexample.mvp.presenter;

import java.text.SimpleDateFormat;

import com.google.inject.Inject;
import com.pennychecker.eventbus.EventBus;
import com.pennychecker.presenter.wicket.WicketContainerDisplay;
import com.pennychecker.presenter.wicket.WicketContainerPresenter;

/**
 * @author Steffen Kaempke
 */
public class UserContainerPresenter extends WicketContainerPresenter<UserContainerPresenter.Display> {
	
	public static final SimpleDateFormat STANDARD_DATE_FORMAT = new SimpleDateFormat("yyyy/mm/dd");
	
	@Inject
	public UserContainerPresenter(Display display, EventBus eventBus, AllUserPresenter allUserPresenter, EditUserPresenter userPresenter) {
		super(display, eventBus, allUserPresenter, userPresenter);

		display.addComponent(allUserPresenter.getDisplay().asComponent());
		display.addComponent(userPresenter.getDisplay().asComponent());
		showPresenter(allUserPresenter);
		
		bind();
		display.setPresenter(this);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public interface Display extends WicketContainerDisplay<UserContainerPresenter> {

	}

	public void refreshDisplay() {
		// TODO Auto-generated method stub

	}
}
