package com.notification.pushNotification.service;
import java.io.FileInputStream;
import java.io.IOException;
import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

@Service
public class FCMInitializer {

	@Value("${app.firebase-configuration-file}")
	private String firebaseConfigpath;
	Logger logger=LoggerFactory.getLogger(FCMInitializer.class);
	
	@PostConstruct
	public void initialize() {
		try {
//			System.out.println("hiiiiiiiii"+firebaseConfigpath);
//			 InputStream serviceAccount = firebaseConfigpath.getInputStream();
			FileInputStream serviceAccount = new FileInputStream("src/main/resources/muhsmobile.json");
            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();
            if (FirebaseApp.getApps().isEmpty()) {
                FirebaseApp.initializeApp(options);
                System.out.println("Firebase application initialized");
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            
        }
	}
}
