/**
 * http://blog.yanivkessler.com/2010/05/wicket-and-guice-alternate-route.html?x=stackoverflow
 */
package com.pennychecker.wicketexample.guice.filter;

import org.apache.wicket.protocol.http.IWebApplicationFactory;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.protocol.http.WicketFilter;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

@Singleton
public class WicketGuiceFilter extends WicketFilter {

 @Inject private Provider<WebApplication> appsProvider;
 
 @Override
 protected IWebApplicationFactory getApplicationFactory() {
  return new IWebApplicationFactory() {   
			public WebApplication createApplication(WicketFilter filter) {    
    return appsProvider.get();
   }
  };
 } 
}
