package de.tekup.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })

public class ProjApplication {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext context = SpringApplication.run(ProjApplication.class, args);
	}

}
