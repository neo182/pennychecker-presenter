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
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.value.ValueMap;

import com.pennychecker.wicketexample.mvp.model.WicketUser;
import com.pennychecker.wicketexample.mvp.presenter.EditUserPresenter;
import com.pennychecker.wicketexample.mvp.presenter.UserContainerPresenter;

/**
 * @author Steffen Kaempke
 */
public class EditUserView extends Panel implements EditUserPresenter.Display{
	
	public static final String VIEW_ID = "panelEditUserView";
	public static final String ID_LABEL_TITLE = VIEW_ID+"LabelTitle";
	
	public static final String ID_FORM = VIEW_ID+"Form";
	public static final String ID_FORM_LABEL_FIRSTNAME = VIEW_ID+"FormLabelFirstname";
	public static final String ID_FORM_LABEL_LASTNAME = VIEW_ID+"FormLabelLastname";
	public static final String ID_FORM_LABEL_BIRTH = VIEW_ID+"FormLabelBirth";
	
	public static final String ID_FORM_LABEL_ERROR_FIRSTNAME = VIEW_ID+"FormLabelErrorFirstname";
	public static final String ID_FORM_LABEL_ERROR_LASTNAME = VIEW_ID+"FormLabelErrorLastname";
	public static final String ID_FORM_LABEL_ERROR_BIRTH = VIEW_ID+"FormLabelErrorBirth";
	
	public static final String ID_FORM_TEXTFIELD_FIRSTNAME = VIEW_ID+"FormTextfieldFirstname";
	public static final String ID_FORM_TEXTFIELD_LASTNAME = VIEW_ID+"FormTextfieldLastname";
	public static final String ID_FORM_TEXTFIELD_BIRTH = VIEW_ID+"FormTextfieldBirth";
	public static final String ID_FORM_BUTTON_CANCEL = VIEW_ID+"FormCancelLink"; 
		
	private EditUserPresenter presenter;
	private Label labelTitle;
	private Label labelFormFirstname;
	private Label labelFormLastname;
	private Label labelFormBirth;	
	private Label labelFormErrorFirstname;
	private Label labelFormErrorLastname;
	private Label labelFormErrorBirth;
	private Link<String> formCancelLink;
	private Form<ValueMap> form;
	private CompoundPropertyModel<ValueMap> compundedPropertyModel;

	public EditUserView() {
		super(VIEW_ID);
		labelTitle = new Label(ID_LABEL_TITLE,"Edit user");
		add(labelTitle);
		compundedPropertyModel = new CompoundPropertyModel<ValueMap>(new ValueMap());
		form = new Form<ValueMap>(ID_FORM,compundedPropertyModel) {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			protected void onSubmit() {
				hideErrorMessages();
				presenter.save_action();
			}
			
		};
		add(form);
		
		labelFormFirstname = new Label(ID_FORM_LABEL_FIRSTNAME,"Firstname");
		form.add(labelFormFirstname);
		
		labelFormLastname = new Label(ID_FORM_LABEL_LASTNAME,"Lastname");
		form.add(labelFormLastname);
		
		labelFormBirth = new Label(ID_FORM_LABEL_BIRTH,"Birth yyyy/mm/dd");
		form.add(labelFormBirth);	
		
		labelFormErrorBirth = new Label(ID_FORM_LABEL_ERROR_BIRTH);
		form.add(labelFormErrorBirth);
		
		labelFormErrorFirstname = new Label(ID_FORM_LABEL_ERROR_FIRSTNAME);
		form.add(labelFormErrorFirstname);
		
		labelFormErrorLastname = new Label(ID_FORM_LABEL_ERROR_LASTNAME);		
		form.add(labelFormErrorLastname);
		
		hideErrorMessages();
		
		form.add(new TextField<String>(ID_FORM_TEXTFIELD_FIRSTNAME).setType(String.class));
		
		form.add(new TextField<String>(ID_FORM_TEXTFIELD_LASTNAME).setType(String.class));
		
		form.add(new TextField<String>(ID_FORM_TEXTFIELD_BIRTH).setType(String.class));
				
		formCancelLink = new Link<String>(ID_FORM_BUTTON_CANCEL) {

			/**
			 * 
			 */
			private static final long serialVersionUID = -632482484843710146L;

			@Override
			public void onClick() {				
				presenter.cancel_action();
			}
			
		};
		add(formCancelLink);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -4516768116171747455L;

	public Component asComponent() {
		return this;
	}

	public void setPresenter(EditUserPresenter presenter) {
		this.presenter = presenter;
	
	}

	public String getFirstname() {
		return (String)form.getModelObject().get(ID_FORM_TEXTFIELD_FIRSTNAME);
	}

	public String getLastname() {
		return (String)form.getModelObject().get(ID_FORM_TEXTFIELD_LASTNAME);
	}

	public String getBirth() {
		return (String)form.getModelObject().get(ID_FORM_TEXTFIELD_BIRTH);
	}

	public void setWicketUser(WicketUser wicketUser) {
		form.getModelObject().put(ID_FORM_TEXTFIELD_FIRSTNAME, wicketUser.getFirstname());
		form.getModelObject().put(ID_FORM_TEXTFIELD_LASTNAME, wicketUser.getLastname());
		form.getModelObject().put(ID_FORM_TEXTFIELD_BIRTH, UserContainerPresenter.STANDARD_DATE_FORMAT.format(wicketUser.getBirth()));	
		hideErrorMessages();
	}

	public void clearForm() {
		form.getModelObject().put(ID_FORM_TEXTFIELD_FIRSTNAME, "");
		form.getModelObject().put(ID_FORM_TEXTFIELD_LASTNAME, "");
		form.getModelObject().put(ID_FORM_TEXTFIELD_BIRTH, "");		
		
		hideErrorMessages();
	}
	
	

	public void setErrorMessageBirth(String message) {
		labelFormErrorBirth.setDefaultModel(Model.of(message));
		labelFormErrorBirth.setVisible(true);
	}

	public void setErrorMessageFirstname(String message) {
		labelFormErrorFirstname.setDefaultModel(Model.of(message));
		labelFormErrorFirstname.setVisible(true);
	}

	public void setErrorMessageLastname(String message) {
		labelFormErrorLastname.setDefaultModel(Model.of(message));
		labelFormErrorLastname.setVisible(true);
	}

	private void hideErrorMessages() {
		labelFormErrorLastname.setVisible(false);
		labelFormErrorFirstname.setVisible(false);
		labelFormErrorBirth.setVisible(false);
	}
	
}

