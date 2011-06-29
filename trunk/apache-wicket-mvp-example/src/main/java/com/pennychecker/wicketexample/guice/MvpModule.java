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
package com.pennychecker.wicketexample.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.pennychecker.eventbus.EventBus;
import com.pennychecker.wicketexample.guice.provider.EventBusProvider;
import com.pennychecker.wicketexample.mvp.presenter.AllUserPresenter;
import com.pennychecker.wicketexample.mvp.presenter.EditUserPresenter;
import com.pennychecker.wicketexample.mvp.presenter.NavigationPresenter;
import com.pennychecker.wicketexample.mvp.presenter.UserContainerPresenter;
import com.pennychecker.wicketexample.mvp.view.AllUserView;
import com.pennychecker.wicketexample.mvp.view.EditUserView;
import com.pennychecker.wicketexample.mvp.view.NavigationView;
import com.pennychecker.wicketexample.mvp.view.UserContainerView;

/**
 * @author Steffen Kaempke
 */
public class MvpModule extends AbstractModule{

	
	@Override
	protected void configure() {
		
		bind(EventBus.class).toProvider(EventBusProvider.class).in(Singleton.class);
		
		bind(NavigationPresenter.Display.class).to(NavigationView.class);
		bind(NavigationPresenter.class).in(Singleton.class);
		
		bind(UserContainerPresenter.Display.class).to(UserContainerView.class);
		bind(UserContainerPresenter.class).in(Singleton.class);
		
		bind(AllUserPresenter.Display.class).to(AllUserView.class);
		bind(AllUserPresenter.class).in(Singleton.class);
		
		bind(EditUserPresenter.Display.class).to(EditUserView.class);
		bind(EditUserPresenter.class).in(Singleton.class);
	}

}
