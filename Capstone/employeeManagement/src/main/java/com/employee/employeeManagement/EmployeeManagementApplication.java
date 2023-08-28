package com.employee.employeeManagement;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * The entry point for the Employee Management application.
 */
@SpringBootApplication
public class EmployeeManagementApplication {
	/**
	 * The main method that starts the Spring Boot application.
	 *
	 * @param args Command line arguments passed to the application.
	 */
	public static void main(String[] args) {

		SpringApplication.run(EmployeeManagementApplication.class, args);
	}
	/**
	 * Bean definition for creating and configuring the ModelMapper instance.
	 *
	 * @return A configured ModelMapper instance.
	 */
	@Bean
	public ModelMapper getModelMapper(){
		return new ModelMapper();
	}
	/**
	 * Bean definition for creating and configuring the PasswordEncoder instance.
	 *
	 * @return A BCryptPasswordEncoder instance for password encoding.
	 */
	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}


}
