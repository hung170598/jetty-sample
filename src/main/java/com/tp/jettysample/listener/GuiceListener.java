package com.tp.jettysample.listener;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;
import com.tp.jettysample.service.UserService;
import com.tp.jettysample.storage.UserStorage;
import com.tp.jettysample.storage.UserStorageImpl;

public class GuiceListener extends GuiceServletContextListener {

	@Override
	protected Injector getInjector() {
		return Guice.createInjector(new ServletModule() {
			@Override
			protected void configureServlets() {
				bind(UserStorage.class).to(UserStorageImpl.class);
				bind(UserService.class);
				serve("/api/*").with(GuiceContainer.class);
			}
		});
	}
}
