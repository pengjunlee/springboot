package org.springframework.boot.tests.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StudyApplication {

	public static void main(String[] args) {

		// 方式一
		// ConfigurableApplicationContext context = SpringApplication.run(StudyApplication.class, args);
		// 方式二
		SpringApplication springApplication = new SpringApplication(StudyApplication.class);
		ConfigurableApplicationContext context = springApplication.run(args);
		System.out.println("beans in context : "+context.getBeanDefinitionCount());

		context.close();
	}

	@Bean
	public Runnable createRunnable(){
		System.out.println("Runnable bean create...");
		return ()->{};
	}
}
