/**
 * http://blog.yanivkessler.com/2010/05/wicket-and-guice-alternate-route.html?x=stackoverflow
 */
package com.pennychecker.wicketexample.guice.provider;

import org.apache.wicket.protocol.http.WebApplication;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provider;
import com.pennychecker.wicketexample.WicketApplication;

public class WicketGuiceAppProvider implements Provider<WebApplication> {

	private final Injector injector;

	@Inject
	public WicketGuiceAppProvider(Injector injector) {
		this.injector = injector;
	}

	public WebApplication get() {
		WicketApplication app = new WicketApplication(injector);
		return app;
	}
}
