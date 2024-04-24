package ru.spb.fibricare.api.doctorapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

@SpringBootApplication(exclude= {UserDetailsServiceAutoConfiguration.class})
public class DoctorapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoctorapiApplication.class, args);
	}

}
