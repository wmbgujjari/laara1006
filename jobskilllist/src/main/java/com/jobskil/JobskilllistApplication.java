package com.jobskil;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;



@SpringBootApplication
@EnableTransactionManagement
public class JobskilllistApplication {


	
	public static void main(String[] args) {
		SpringApplication.run(JobskilllistApplication.class, args);
	}

}
