package com.example.demo;

import java.net.InetAddress;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.commons.util.InetUtils;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.EurekaInstanceConfigBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class MyEurekaJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyEurekaJpaApplication.class, args);
	}
	
	@Bean
	@Autowired
	public EurekaInstanceConfigBean eurekaInstanceConfig(InetUtils inetUtils) {
		
		EurekaInstanceConfigBean config=new EurekaInstanceConfigBean(inetUtils);
		String ip=null;
		try {
			
			ip=InetAddress.getLocalHost().getHostAddress();
			
		}catch(Exception e) {
			
		}
		config.setNonSecurePort(8085);
		config.setIpAddress(ip);
		config.setPreferIpAddress(true);
		return config;
		
		
	}
	
	

}
