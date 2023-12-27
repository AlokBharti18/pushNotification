package com.notification.pushNotification.service;
import com.notification.pushNotification.model.PushNotificationRequest;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notification.pushNotification.model.PushNotificationRequest;
import com.notification.pushNotification.service.FCMService;
@Service
public class PushNotificationService {
	
	private Logger logger= LoggerFactory.getLogger(PushNotificationService.class);
	
	
	private FCMService fcmservice;

	public PushNotificationService(FCMService fcmservice) {
		
		this.fcmservice = fcmservice;
	}
	
	public void sendPushNotificationToToken(PushNotificationRequest request) {
		System.out.println("line 26");
		try {
			fcmservice.sendMessageToToken(request);
		}catch(Exception e) {
            logger.error(e.getMessage());
		}
	}

}
