package com.notification.pushNotification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PushNotificationApplication {

	public static void main(String[] args) {
		
		
		SpringApplication.run(PushNotificationApplication.class, args);
		System.out.println("push notification working");
	}

}
