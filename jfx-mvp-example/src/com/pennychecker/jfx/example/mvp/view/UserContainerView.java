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
package com.pennychecker.jfx.example.mvp.view;

import com.pennychecker.jfx.example.mvp.presenter.UserContainerPresenter;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;

/**
 *
 * @author Steffen Kämpke
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
