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
import org.apache.wicket.markup.html.panel.Panel;

import com.pennychecker.presenter.wicket.WicketDisplay;
import com.pennychecker.wicketexample.mvp.presenter.UserContainerPresenter;

/**
 * @author Steffen Kaempke
 */
public class UserContainerView extends Panel implements UserContainerPresenter.Display {

	public static final String VIEW_ID = "panelUserContainerView";
	private UserContainerPresenter presenter;

	public UserContainerView() {
		super(VIEW_ID);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 6100015125034775143L;

	public void showComponent(final Component component) {
		VisitComponent visitor = new VisitComponent();
		UserContainerView.this.visitChildren(visitor);
		component.setVisible(true);
	}

	public void addComponent(Component component) {
		this.add(component);
		component.setVisible(false);
	}

	public void removeComponent(Component component) {

	}

	public Component asComponent() {
		return this;
	}

	public void setPresenter(UserContainerPresenter presenter) {
		this.presenter = presenter;
	}

	private static class VisitComponent implements IVisitor<Component> {
		public Object component(Component component) {
			/**
			 * Hide the visible compoenent. Its a workaround. If you have a better idea, you can write me an email to sk@pennychecker.com.
			 */
			if ( component instanceof WicketDisplay<?> ) {
				component.setVisible(false);
			}			
			return IVisitor.CONTINUE_TRAVERSAL;
		};
	}

}
