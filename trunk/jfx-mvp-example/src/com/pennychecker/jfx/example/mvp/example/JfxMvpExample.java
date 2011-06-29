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
package com.pennychecker.jfx.example.mvp.example;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.pennychecker.jfx.example.mvp.guice.MvpModule;
import com.pennychecker.jfx.example.mvp.presenter.UserContainerPresenter;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Steffen Kämpke
 */
public class JfxMvpExample extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(JfxMvpExample.class, args);
    }

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("Java Fx 2.0 Mvp Example / Steffen Kämpke");

        final Injector injector = Guice.createInjector(new MvpModule());
        final UserContainerPresenter userContainerPresenter = injector.getInstance(UserContainerPresenter.class);

        Scene scene = new Scene(userContainerPresenter.getDisplay().asParent(), 500, 500);

        primaryStage.setScene(scene);
        primaryStage.setVisible(true);               
    }
}
