package com.notification.pushNotification.controller;

import java.util.concurrent.ExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.notification.pushNotification.model.PushNotificationRequest;
import com.notification.pushNotification.model.PushNotificationResponse;
import com.notification.pushNotification.service.FCMService;
import com.notification.pushNotification.service.PushNotificationService;

@RestController
@RequestMapping("/notification")
public class PushNotificationController {

	@Autowired
    private FCMService fcmService;
	
	private PushNotificationService pushNotificationService;
	
	public PushNotificationController(PushNotificationService pushNotificationService) {
		this.pushNotificationService=pushNotificationService;
	}
	@GetMapping("/hello")
	public String sendMessage() {
		return "hi welcome to firebase";
	}
    @PostMapping("/token")
    public ResponseEntity <PushNotificationRequest>sendNotification(@RequestBody PushNotificationRequest request) throws ExecutionException, InterruptedException {
//        System.out.println("line 31"+ request);
    	pushNotificationService.sendPushNotificationToToken(request);
        return new ResponseEntity(new PushNotificationResponse(HttpStatus.OK.value(), "Notification has been sent."), HttpStatus.OK);
    }
}
