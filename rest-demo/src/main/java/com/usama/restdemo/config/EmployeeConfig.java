package com.usama.restdemo.config;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.usama.restdemo.entity.Employee;
import com.usama.restdemo.repo.EmployeeRepo;

@Configuration
public class EmployeeConfig {

//	private static final Logger log = (Logger) LoggerFactory.getLogger(EmployeeConfig.class);

	@Bean
	CommandLineRunner commandLineRunner(EmployeeRepo employeeRepo) {
		return args -> {
//			log.info("preloading " + employeeRepo.save(new Employee("Mohammed usama", "Professor")));
//			log.info("Preloading " + employeeRepo.save(new Employee("Tom Holland", "Teacher")));
			employeeRepo.save(new Employee("Mohammed usama", "Professor"));
			employeeRepo.save(new Employee("Tom Holland", "Teacher"));
		};
	}

}
