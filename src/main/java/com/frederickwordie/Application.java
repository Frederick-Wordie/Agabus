package com.frederickwordie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolExecutorFactoryBean;

@EnableAsync
@EnableScheduling
@SpringBootApplication
public class Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public ThreadPoolExecutorFactoryBean taskScheduler(){
		ThreadPoolExecutorFactoryBean threadTask = new ThreadPoolExecutorFactoryBean();
		threadTask.setCorePoolSize(30);
		threadTask.setMaxPoolSize(50);
		threadTask.setQueueCapacity(200);
		return threadTask;
		
	}
	
}
