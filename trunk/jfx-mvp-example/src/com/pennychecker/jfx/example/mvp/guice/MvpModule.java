/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pennychecker.jfx.example.mvp.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.pennychecker.eventbus.EventBus;
import com.pennychecker.jfx.example.mvp.presenter.AllUserPresenter;
import com.pennychecker.jfx.example.mvp.presenter.EditUserPresenter;
import com.pennychecker.jfx.example.mvp.presenter.UserContainerPresenter;
import com.pennychecker.jfx.example.mvp.view.AllUserView;
import com.pennychecker.jfx.example.mvp.view.EditUserView;
import com.pennychecker.jfx.example.mvp.view.UserContainerView;
import com.pennychecker.jfx.example.repository.UserRepository;

/**
 *
 * @author iolaus
 */
public class MvpModule extends AbstractModule{

    @Override
    protected void configure() {
        bind(EditUserPresenter.Display.class).to(EditUserView.class).in(Singleton.class);
        bind(EditUserPresenter.class).in(Singleton.class);

        bind(AllUserPresenter.Display.class).to(AllUserView.class).in(Singleton.class);
        bind(AllUserPresenter.class).in(Singleton.class);

        bind(UserContainerPresenter.Display.class).to(UserContainerView.class).in(Singleton.class);
        bind(UserContainerPresenter.class).in(Singleton.class);

        bind(EventBus.class).toProvider(EventBusProvider.class).in(Singleton.class);

        bind(UserRepository.class);
    }
    
}
