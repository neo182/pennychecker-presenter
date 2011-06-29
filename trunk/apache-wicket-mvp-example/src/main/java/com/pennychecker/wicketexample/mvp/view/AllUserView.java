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

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.AjaxFormComponentUpdatingBehavior;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.ListChoice;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

import com.pennychecker.wicketexample.mvp.model.WicketUser;
import com.pennychecker.wicketexample.mvp.presenter.AllUserPresenter;

/**
 * @author Steffen Kaempke
 */
public class AllUserView extends Panel implements AllUserPresenter.Display {

	public static final String VIEW_ID = "panelAllUserView";
	public static final String ID_LABEL_TITLE = VIEW_ID + "LabelTitle";
	public static final String ID_LABEL_SELECTED_USER = VIEW_ID + "LabelSelectedUser";
	public static final String ID_USER_LIST_CHOISE = VIEW_ID + "ListChoiseUser";
	public static final String ID_USER_FORM = VIEW_ID + "Form";
	
	public static final String ID_FORM_BUTTON_EDIT_USER = ID_USER_FORM + "ButtonEdit";
	public static final String ID_FORM_BUTTON_REMOVE_USER = ID_USER_FORM + "ButtonRemove";
	
	private AllUserPresenter presenter;
	private Label labelTitle;
	private Label labelSelectedUSer;
	private ListChoice<String> listChoise;
	private Form<Void> form;
	
	
	private String selectedUser = "There are no user";
	private List<String> users = new ArrayList<String>();

	public AllUserView() {
		super(VIEW_ID);
		labelTitle = new Label(ID_LABEL_TITLE, "All user");
		add(labelTitle);
		
		form = new Form<Void>(ID_USER_FORM) {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			protected void onSubmit() {
				System.out.println(selectedUser);
			}
			
		};
		add(form);
		users.add("There are no user");
		listChoise = new ListChoice<String>(ID_USER_LIST_CHOISE,new PropertyModel<String>(this, "selectedUser"),users);		
		listChoise.setMaxRows(5);
		
		listChoise.add(new AjaxFormComponentUpdatingBehavior("onchange") {
            protected void onUpdate(AjaxRequestTarget target) {
                labelSelectedUSer.setDefaultModel(Model.of(selectedUser));
                presenter.userSelected_action(listChoise.getChoices().indexOf(selectedUser));
                target.addComponent(labelSelectedUSer);
            }
        });
		
		form.add(listChoise);
		
		labelSelectedUSer = new Label(ID_LABEL_SELECTED_USER, "There are no user");
		labelSelectedUSer.setOutputMarkupId(true);
		add(labelSelectedUSer);
		form.add(new Button(ID_FORM_BUTTON_EDIT_USER,Model.of("edit")) {

			@Override
			public void onSubmit() {
				presenter.editUser_action();
			}
			
		});
		
		form.add(new Button(ID_FORM_BUTTON_REMOVE_USER,Model.of("remove")) {

			@Override
			public void onSubmit() {
				presenter.removeUser_action();
			}
			
		});
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 5786562678082317739L;

	public Component asComponent() {
		return this;
	}

	public void setPresenter(AllUserPresenter presenter) {
		this.presenter = presenter;
	}

	public void setSelectedUser(WicketUser selectedUser) {
		for (String user : users) {
			if (selectedUser.getFirstname().equals(user)) {
				this.selectedUser = user;
				labelSelectedUSer.setDefaultModel(Model.of(this.selectedUser));
			}
		}
	}

	public void setErrorMessage(String string) {
		// TODO Auto-generated method stub

	}

	public void setWicketusers(List<WicketUser> users) {
		
		listChoise.getChoices().clear();
		final List<String> userNames = new ArrayList<String>();
		for (int i = 0; i<users.size(); i++) {
			userNames.add(users.get(i).getFirstname());
			
		}//1979/03/03
		this.users = userNames;
		listChoise.setChoices(this.users);
		
	}

	public void clearSelection() {
		selectedUser = null;
	}
  
}
