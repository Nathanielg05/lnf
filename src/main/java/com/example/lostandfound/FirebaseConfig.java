package com.example.lostandfound;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.context.annotation.Configuration;

import jakarta.annotation.PostConstruct;
import java.io.InputStream;

@Configuration
public class FirebaseConfig {

    @Autowired
    private ResourceLoader resourceLoader;

    @PostConstruct
    public void initialize() {
        try {
            if (FirebaseApp.getApps().isEmpty()) {
                // Spring resource loader looks in src/main/resources automatically using classpath:
                Resource resource = resourceLoader.getResource("classpath:serviceAccountKey.json");

                if (!resource.exists()) {
                    System.err.println("CRITICAL ERROR: serviceAccountKey.json not found by ResourceLoader!");
                    return;
                }

                InputStream serviceAccount = resource.getInputStream();

                FirebaseOptions options = FirebaseOptions.builder()
                        .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                        .build();

                FirebaseApp.initializeApp(options);
                System.out.println(">>> FIREBASE INITIALIZED SUCCESSFULLY!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}