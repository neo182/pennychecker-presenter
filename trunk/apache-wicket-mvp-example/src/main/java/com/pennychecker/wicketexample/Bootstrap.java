/**
 * http://blog.yanivkessler.com/2010/05/wicket-and-guice-alternate-route.html?x=stackoverflow
 */
package com.pennychecker.wicketexample;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.pennychecker.wicketexample.guice.MvpModule;
import com.pennychecker.wicketexample.guice.WebModule;

public final class Bootstrap extends GuiceServletContextListener {
	@Override
	protected Injector getInjector() {
		return Guice.createInjector(new MvpModule(), new WebModule());
	}
}
