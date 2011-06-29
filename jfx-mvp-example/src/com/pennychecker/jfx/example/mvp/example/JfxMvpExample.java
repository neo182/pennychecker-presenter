/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pennychecker.jfx.example.mvp.example;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.pennychecker.jfx.example.mvp.guice.MvpModule;
import com.pennychecker.jfx.example.mvp.presenter.UserContainerPresenter;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author sk
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
