package com.jobskills;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class task1 {

    @Scheduled(fixedDelay = 5000)
    public void taskB() throws InterruptedException {
        System.out.println("[B] Starting new cycle of scheduled task");

        System.out.println("[B] Done the cycle of scheduled task");
    }  
}
