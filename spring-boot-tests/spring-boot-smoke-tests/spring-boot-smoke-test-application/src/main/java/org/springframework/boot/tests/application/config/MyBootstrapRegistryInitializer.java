package org.springframework.boot.tests.application.config;

import org.springframework.boot.BootstrapContextClosedEvent;
import org.springframework.boot.BootstrapRegistry;
import org.springframework.boot.BootstrapRegistryInitializer;
import org.springframework.boot.tests.application.domain.Person;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.annotation.Order;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Order(100)
public class MyBootstrapRegistryInitializer implements BootstrapRegistryInitializer {
	@Override
	public void initialize(BootstrapRegistry registry) {

		ApplicationListener<BootstrapContextClosedEvent> listener = new ApplicationListener<BootstrapContextClosedEvent>(){

			@Override
			public void onApplicationEvent(BootstrapContextClosedEvent event) {
				Map<String,Object> map = new HashMap<>();
				Person p1 = new Person("lisi",18);
				Person p2 = new Person("wangwu",22);
				map.put("lisi",p1);
				map.put("wangwu",p2);

				String personname = event.getApplicationContext().getEnvironment().getProperty("person.name", String.class);
				System.out.println(personname);
				event.getApplicationContext().getBeanFactory().registerSingleton("persons",map);

				System.out.println("MyBootstrapRegistryInitializer get beans cout: "+event.getApplicationContext().getBeanDefinitionCount());

				ConfigurableApplicationContext c = event.getApplicationContext();
				Iterator<String> beanNamesIterator = c.getBeanFactory().getBeanNamesIterator();
				while (beanNamesIterator.hasNext()){
					System.out.println(beanNamesIterator.next());
				}

			}
		};

		registry.addCloseListener(listener);
		System.out.println("MyBootstrapRegistryInitializer initialize...");
	}
}
