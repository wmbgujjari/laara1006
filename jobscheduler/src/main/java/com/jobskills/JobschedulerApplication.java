package com.jobskills;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.transaction.annotation.Transactional;

import com.harleeninfo.flysskill.storage.StorageProperties;
import com.harleeninfo.flysskill.storage.service.FileSystemStorageService;
import com.jobskills.entity.dir_user;
import com.jobskills.repo.dir_userRepo;
import com.jobskills.service.DirService;


@SpringBootApplication
@EnableScheduling
@ComponentScan(basePackages = "com.*")
@EntityScan("com.jobskills.entity")
@EnableConfigurationProperties(StorageProperties.class)
public class JobschedulerApplication implements CommandLineRunner {
	
    @Autowired
    dir_userRepo dir_userRepository;
	
	private final int POOL_SIZE = 2;
	public static void main(String[] args) {
		SpringApplication.run(JobschedulerApplication.class, args);
	}
	
	@Transactional(readOnly = true)
	public void run(String... args) throws Exception {

        

     //  System.out.println("DATASOURCE = " + dir_userRepository.findByEmailReturnStream("ADE-IT"));

        System.out.println("\n3.findByDate(Date date)...");
        
   //     System.out.println("DATASOURCE = " +dir_userRepository.findAll());
       /* try (Stream<dir_user> stream = dir_userRepository.findByEmailReturnStream("ADE-IT")) {
            stream.forEach(x -> System.out.println(x));
        }*/
        
     //  dir_user U = (dir_user) dir_userRepository.findByusername("ADE-IT");
       
        
       // System.out.println("Done!"+ U.getUsername());
        
        for (dir_user customer : dir_userRepository.findByusername("5000-3551")) {
            System.out.println(customer.getUsername());
        }
    }	
	
	@Bean
	public ThreadPoolTaskScheduler threadPoolTaskScheduler() {
	    ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
	    threadPoolTaskScheduler.setPoolSize(POOL_SIZE);
	    return threadPoolTaskScheduler;
	}	
}