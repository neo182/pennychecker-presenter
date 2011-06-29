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
package com.pennychecker.wicketexample;

import org.apache.wicket.ResourceReference;
import org.apache.wicket.markup.html.CSSPackageResource;
import org.apache.wicket.markup.html.WebPage;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.pennychecker.wicketexample.mvp.presenter.NavigationPresenter;
import com.pennychecker.wicketexample.mvp.presenter.UserContainerPresenter;

/**
 * @author Steffen Kaempke
 */
public class HomePage extends WebPage {

	private static final long serialVersionUID = 1L;
	private Injector injector;

	public HomePage() {
		final NavigationPresenter navigationPresenter = injector.getInstance(NavigationPresenter.class);
		add(navigationPresenter.getDisplay().asComponent());
		
		final UserContainerPresenter userContainerPresenter = injector.getInstance(UserContainerPresenter.class);
		add(userContainerPresenter.getDisplay().asComponent());
		
		ResourceReference cssRef = new ResourceReference(HomePage.class, "main.css");
		add(CSSPackageResource.getHeaderContribution(cssRef));
	}

	@Inject
	public void setInjector(Injector injector) {
		this.injector = injector;
	}
}
