package com.employee.employeeManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
* The entry point for the Employee Management application.
*/
@SpringBootApplication
@EnableTransactionManagement
public class EmployeeManagementApplication {
/**
* Runs the main application.
* @param args Command line arguments.
*/
public final void run(final String[] args) {
SpringApplication.run(EmployeeManagementApplication.class, args);
}
/**
* The main method that starts the Spring Boot application.
* @param args Command line arguments passed to the application.
*/
public static void main(final String[] args) {
new EmployeeManagementApplication().run(args);
}

/**
* Bean definition for creating and configuring the
* PasswordEncoder instance.
*
* @return A BCryptPasswordEncoder instance for password encoding.
*/
@Bean
public PasswordEncoder passwordEncoder() {
return new BCryptPasswordEncoder();
}
}
