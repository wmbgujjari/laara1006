package com.jobskills;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {
    
	@Scheduled(fixedDelay = 5000)
    public void taskA() throws InterruptedException {
        System.out.println("[A] Starting new cycle of scheduled task");

        // Simulate an operation that took 5 seconds.
        long startTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - startTime <= 5000);

        System.out.println("[A] Done the cycle of scheduled task");
    }


    
}