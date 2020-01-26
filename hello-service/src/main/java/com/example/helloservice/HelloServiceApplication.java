package com.example.helloservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class HelloServiceApplication {

	@Autowired
	Environment environment;

	@RequestMapping(value = "/hello",produces = {"application/json"})
	public Map<String,String> hello(){
		Map<String,String> response=new HashMap<String,String>(){{
			this.put("status","OK");
			this.put("message","hello from service");
			this.put("port",environment.getProperty("server.port"));
		}};
		try {
			Thread.sleep(3220);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return response;
	}

	public static void main(String[] args) {
		SpringApplication.run(HelloServiceApplication.class, args);
	}

}
