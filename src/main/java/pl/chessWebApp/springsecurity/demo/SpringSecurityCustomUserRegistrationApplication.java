package pl.chessWebApp.springsecurity.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringSecurityCustomUserRegistrationApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringSecurityCustomUserRegistrationApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityCustomUserRegistrationApplication.class, args);
	}
}
