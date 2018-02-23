package com.pjain.rest.config;

import javax.inject.Inject;

import org.eclipse.microprofile.config.inject.ConfigProperty;

public class HelloConfiguration {

	@Inject
	@ConfigProperty(name = "kProp", defaultValue = "Duke")
	String user;

	public String getUser() {
		return user;
	}

}