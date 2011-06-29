/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pennychecker.jfx.example.mvp.view;

import com.pennychecker.jfx.example.mvp.presenter.UserContainerPresenter;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;

/**
 *
 * @author iolaus
 */
public final class UserContainerView extends Parent implements UserContainerPresenter.Display {

    private StackPane stackPane;

    public UserContainerView() {
        initialize();
    }
  
    public void showParent(Parent parent) {
        parent.toFront();  
        for (Node node : parent.getChildrenUnmodifiable()) {
            node.requestFocus();
        }
    }

    public void addParent(Parent parent) {
        stackPane.getChildren().add(parent);
    }

    public void removeParent(Parent parent) {
        stackPane.getChildren().remove(parent);
    }

    public Parent asParent() {
        return this;
    }

    private void initialize() {
        stackPane = new StackPane();      
        this.getChildren().add(stackPane);
    }
}
