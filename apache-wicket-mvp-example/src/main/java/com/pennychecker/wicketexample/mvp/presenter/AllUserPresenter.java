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

import java.util.ArrayList;
import java.util.List;

import com.google.inject.Inject;
import com.pennychecker.eventbus.EventBus;
import com.pennychecker.presenter.event.PresenterRevealedEvent;
import com.pennychecker.presenter.wicket.WicketDisplay;
import com.pennychecker.presenter.wicket.WicketPresenter;
import com.pennychecker.wicketexample.event.EditUserEvent;
import com.pennychecker.wicketexample.event.EditUserEventHandler;
import com.pennychecker.wicketexample.event.UserChangedEvent;
import com.pennychecker.wicketexample.event.UserChangedEventHandler;
import com.pennychecker.wicketexample.mvp.model.WicketUser;

/**
 * @author Steffen Kaempke
 */
public class AllUserPresenter extends WicketPresenter<AllUserPresenter.Display> {

	private final List<WicketUser> users = new ArrayList<WicketUser>();
	private WicketUser selectedUser;

	@Inject
	public AllUserPresenter(Display display, EventBus eventBus) {
		super(display, eventBus);
		fetchUsers();
		bind();
		display.setPresenter(this);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -186888559414222126L;

	public interface Display extends WicketDisplay<AllUserPresenter> {

		void setSelectedUser(WicketUser selectedUser);

		void setErrorMessage(String string);

		void setWicketusers(List<WicketUser> users);

		void clearSelection();

	}

	public void refreshDisplay() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void onBind() {

		registerHandler(eventBus.addHandler(EditUserEvent.TYPE, new EditUserEventHandler() {

			public void onEditUserEvent(EditUserEvent event) {
				if (null == event.getUser()) {
					selectedUser = null;
				}
			}
		}));

		registerHandler(eventBus.addHandler(UserChangedEvent.TYPE, new UserChangedEventHandler() {

			public void onShowAllUserEvent(UserChangedEvent event) {

				if (null != selectedUser) {
					users.remove(selectedUser);
				}

				WicketUser wicketUser = event.getWicketUser();

				if (null != wicketUser) {

					users.add(wicketUser);
					display.setWicketusers(users);
					selectedUser = wicketUser;
					display.setSelectedUser(selectedUser);
				}

				eventBus.fireEvent(new PresenterRevealedEvent(AllUserPresenter.this));
			}
		}));

	}

	public void userSelected_action(int index) {
		
		if ( index < 0 ) {
			display.clearSelection();
			return;
		}
		selectedUser = users.get(index);
		System.out.println("selectedUser: " + selectedUser.getFirstname());
	}

	public void editUser_action() {
		if (null == selectedUser) {
			display.setErrorMessage("Please select a user.");
			return;
		}

		eventBus.fireEvent(new EditUserEvent(selectedUser));
	}

	public void removeUser_action() {
		if (null == selectedUser) {
			display.setErrorMessage("Please select a user.");
			return;
		}

		users.remove(selectedUser);
		selectedUser = null;
		display.setWicketusers(users);
	}

	@Override
	protected void onUnbind() {
		// TODO Auto-generated method stub

	}

	private void fetchUsers() {
		// TODO Auto-generated method stub

	}
}
