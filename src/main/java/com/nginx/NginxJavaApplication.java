package com.nginx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.abtasty.flagship.main.Flagship;
import com.abtasty.flagship.main.FlagshipConfig;

@SpringBootApplication
public class NginxJavaApplication {

	public static void main(String[] args) {
		Flagship.start("envId", "apiKey", new FlagshipConfig.DecisionApi()
	              .withStatusListener(newStatus -> {
	                  if (newStatus == Flagship.Status.READY)
	                      System.out.println("SDK is ready to use.");
	              })
	              .withTimeout(200));
		SpringApplication.run(NginxJavaApplication.class, args);
	}

}
