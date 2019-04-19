package com.provider.clientprovider;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class ClientProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientProviderApplication.class, args);
	}
	@Value("${server.port}")
	String port;
	@RequestMapping(value = "/hi",method = RequestMethod.GET)
	public String home(@RequestParam(value = "name",defaultValue="forezip")String name){
		return "hi "+name+" ,i am from prot "+port;
	}

}

