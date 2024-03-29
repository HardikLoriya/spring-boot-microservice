package com.secure.microservice.cloud.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.cloud.circuitbreaker.resilience4j.ReactiveResilience4JAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.HystrixCircuitBreakerAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.DispatcherHandler;

@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
@ConditionalOnClass({ DispatcherHandler.class,
	ReactiveResilience4JAutoConfiguration.class,
	HystrixCircuitBreakerAutoConfiguration.class })
public class CloudGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudGatewayApplication.class, args);
	}
	
	@Bean
    public RestTemplate template(){
       return new RestTemplate();
    }

}
