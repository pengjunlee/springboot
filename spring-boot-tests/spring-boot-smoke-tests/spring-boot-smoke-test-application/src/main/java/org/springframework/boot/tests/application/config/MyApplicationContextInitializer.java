package org.springframework.boot.tests.application.config;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.annotation.Order;


@Order(1)
public class MyApplicationContextInitializer  implements ApplicationContextInitializer {
	@Override
	public void initialize(ConfigurableApplicationContext applicationContext) {
		System.out.println("MyApplicationContextInitializer initialize...");
	}
}
