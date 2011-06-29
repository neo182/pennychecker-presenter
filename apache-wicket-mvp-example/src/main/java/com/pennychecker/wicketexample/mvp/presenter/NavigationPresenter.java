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

import com.google.inject.Inject;
import com.pennychecker.eventbus.EventBus;
import com.pennychecker.presenter.wicket.WicketDisplay;
import com.pennychecker.presenter.wicket.WicketPresenter;
import com.pennychecker.wicketexample.event.EditUserEvent;
import com.pennychecker.wicketexample.event.UserChangedEvent;

/**
 * @author Steffen Kaempke
 */
public final class NavigationPresenter extends WicketPresenter<NavigationPresenter.Display> {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = -3579400461775478562L;

	@Inject
	public NavigationPresenter(Display display, EventBus eventBus) {
		super(display, eventBus);	
		bind();
		display.setPresenter(this);
	}

	public interface Display extends WicketDisplay<NavigationPresenter> {

	}

	public void refreshDisplay() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onBind() {

	}

	@Override
	protected void onUnbind() {
		// TODO Auto-generated method stub
		
	}

	public void showAllUsers_action() {		
		eventBus.fireEvent(new UserChangedEvent(null));
	}

	public void createNewUser_action() {
		eventBus.fireEvent(new EditUserEvent(null));
	}
}
