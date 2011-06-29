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

import java.util.Date;

import com.google.inject.Inject;
import com.pennychecker.eventbus.EventBus;
import com.pennychecker.presenter.event.PresenterRevealedEvent;
import com.pennychecker.presenter.wicket.WicketDisplay;
import com.pennychecker.presenter.wicket.WicketPresenter;
import com.pennychecker.wicketexample.event.EditUserEvent;
import com.pennychecker.wicketexample.event.EditUserEventHandler;
import com.pennychecker.wicketexample.event.UserChangedEvent;
import com.pennychecker.wicketexample.mvp.model.WicketUser;

/**
 * @author Steffen Kaempke
 */
public final class EditUserPresenter extends WicketPresenter<EditUserPresenter.Display> {
	
	private WicketUser wicketUser;
	
	@Inject
	public EditUserPresenter(Display display, EventBus eventBus) {
		super(display, eventBus);
		bind();
		display.setPresenter(this);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -186888559414222126L;

	public interface Display extends WicketDisplay<EditUserPresenter> {

		String getFirstname();

		String getLastname();

		String getBirth();

		void setWicketUser(WicketUser wicketUser);

		void clearForm();

		void setErrorMessageBirth(String string);

		void setErrorMessageFirstname(String string);

		void setErrorMessageLastname(String string);

	}

	public void refreshDisplay() {

	}

	@Override
	protected void onBind() {
		registerHandler(eventBus.addHandler(EditUserEvent.TYPE, new EditUserEventHandler() {
			
			public void onEditUserEvent(EditUserEvent event) {
				wicketUser = event.getUser();
				
				if ( null == wicketUser ) {
					display.clearForm();
				} else {
					display.setWicketUser(wicketUser);
				}
				
				eventBus.fireEvent(new PresenterRevealedEvent(EditUserPresenter.this));
			}
		}));
	}

	@Override
	protected void onUnbind() {

	}

	public void save_action() {
		final String firstname = display.getFirstname();
		final String lastname = display.getLastname();
		final String birth = display.getBirth();
		
		if ( null == wicketUser ) {
			wicketUser = new WicketUser();
		}
		
		final Date userBirth;
		try {
			userBirth = UserContainerPresenter.STANDARD_DATE_FORMAT.parse(birth);
		} catch (Exception e) {
			display.setErrorMessageBirth("The birth date is wrong.");
			return;
		}
		
		if ( firstname.isEmpty() ) {
			display.setErrorMessageFirstname("The lastname is empty.");
			return;
		}
		
		if ( lastname.isEmpty() ) {
			display.setErrorMessageLastname("The firstname is empty.");
			return;
		}
		
		wicketUser.setBirth(userBirth);
		wicketUser.setFirstname(firstname);
		wicketUser.setLastname(lastname);
		
		eventBus.fireEvent(new UserChangedEvent(wicketUser));
		
	}

	public void cancel_action() {
		eventBus.fireEvent(new UserChangedEvent(null));
	}
}
