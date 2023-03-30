package com.notify.NotifyEgerton.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/addUniversity").setViewName("addUniversity");
		registry.addViewController("/index").setViewName("index");
		registry.addViewController("/").setViewName("index");
		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/403").setViewName("403");
		registry.addViewController("/community").setViewName("community");
		registry.addViewController("/createCommunity").setViewName("createCommunity");
		registry.addViewController("/createGroup").setViewName("createGroup");
		registry.addViewController("/group").setViewName("group");
		registry.addViewController("/homepage").setViewName("homepage");
		registry.addViewController("/individualGroup").setViewName("individualGroup");
		registry.addViewController("/profile").setViewName("profile");
		registry.addViewController("/registration").setViewName("registration");
                registry.addViewController("/restPassword").setViewName("restPassword");
                registry.addViewController("/Help").setViewName("Help");
	}
}
