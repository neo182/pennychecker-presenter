/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pennychecker.jfx.example.mvp.view;

import com.pennychecker.jfx.example.mvp.model.User;
import com.pennychecker.jfx.example.mvp.presenter.EditUserPresenter;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author iolaus
 */
public final class EditUserView extends Parent implements EditUserPresenter.Display {

    private TextBox textBoxFirstname;
    private TextBox textBoxLastname;
    private Label labelFirstname;
    private Label labelLastname;
    private Button buttonSave;
    private Button buttonCancel;
    private VBox vBox;

    public EditUserView() {
        initialize();
    }

    public Node getSaveButton() {
        return buttonSave;
    }

    public Node getCancelButton() {
        return buttonCancel;
    }

    public String getFirstname() {
        return textBoxFirstname.getText();
    }

    public String getLastName() {
        return textBoxLastname.getText();
    }

    public void setErrorMessage(String string) {
    }

    public void clearForm() {
        textBoxFirstname.setText("");
        textBoxLastname.setText("");
    }

    public void setUser(User user) {
        if (null == user) {
            textBoxFirstname.setText("");
            textBoxLastname.setText("");
        } else {
            textBoxFirstname.setText(user.getFirstname());
            textBoxLastname.setText(user.getLastname());
        }
    }

    public void setWarningMessage(String string) {
        
    }

    public Parent asParent() {
        return this;
    }

    private void initialize() {
        textBoxFirstname = new TextBox();
        textBoxLastname = new TextBox();
        labelFirstname = new Label("Firstname");
        labelLastname = new Label("Lastname");
        buttonCancel = new Button("Cancel");
        buttonSave = new Button("Save");
        vBox = new VBox(10);
        vBox.getChildren().addAll(labelFirstname, textBoxFirstname, labelLastname, textBoxLastname, buttonCancel, buttonSave);
        this.getChildren().add(vBox);
        vBox.setPrefSize(500, 500);
        vBox.setStyle("-fx-background-color: #FBFFDB");
        
    }
}
