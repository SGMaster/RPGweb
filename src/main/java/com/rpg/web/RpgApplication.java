package com.rpg.web;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.rpg.web.user.model.User;

@SpringBootApplication
public class RpgApplication {

	public static void main(String[] args) {
		SpringApplication.run(RpgApplication.class, args);
	}
	
	@PostConstruct
	public void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("GMT-0300"));
	}
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedMethods("GET", "POST", "PUT", "DELETE");
			}
		};
	}

}
