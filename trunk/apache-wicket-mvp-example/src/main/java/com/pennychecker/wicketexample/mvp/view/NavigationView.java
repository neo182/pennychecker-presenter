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
package com.pennychecker.wicketexample.mvp.view;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;

import com.pennychecker.wicketexample.mvp.presenter.NavigationPresenter;

/**
 * @author Steffen Kaempke
 */
public class NavigationView extends Panel implements NavigationPresenter.Display{
	
	private static final String VIEW_ID = "panelNavigationView";
	private static final String ID_LINK_ALL_USERS = VIEW_ID+"ButtonLinkAllUsers";
	private static final String ID_LINK_NEW_USER = VIEW_ID+"ButtonLinkNewUser";

	private static final long serialVersionUID = 1L;
	private NavigationPresenter presenter;
	
	private Link linkAllUsers;
	private Link linkNewUser;
	
	public NavigationView() {
		super(VIEW_ID);
		initializeView();
	}	
	
	public void initializeView() {			
		linkAllUsers = new Link(ID_LINK_ALL_USERS) {
			public void onClick() {
				NavigationView.this.presenter.showAllUsers_action();
			}
		};
		add(linkAllUsers);
		
		linkNewUser = new Link(ID_LINK_NEW_USER) {
			public void onClick() {
				NavigationView.this.presenter.createNewUser_action();
			}
		};
		add(linkNewUser);
	}
	
	public Component asComponent() {
		return this;
	}

	public void setPresenter(NavigationPresenter presenter) {
		this.presenter = presenter;
	}
}
