package com.example.hotel_booking;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

@SpringBootApplication
public class HotelBookingApplication {

	public static void main(String[] args) throws IOException {

		// put this line on the top always or if we put it after firebase setup it will
		// cause error
		/* SpringApplication.run(HotelBookingApplication.class, args); */

		// setup connection to firebase using serviceAccountKey token
		ClassLoader classLoader = HotelBookingApplication.class.getClassLoader();
		File file = new File(Objects.requireNonNull(classLoader.getResource("serviceAccountKey.json")).getFile());
		FileInputStream serviceAccount = new FileInputStream(file.getAbsolutePath());

		FirebaseOptions options = FirebaseOptions.builder()
				.setCredentials(GoogleCredentials.fromStream(serviceAccount))
				.setDatabaseUrl("https://hotel-booking-386b5-default-rtdb.europe-west1.firebasedatabase.app")
				.build();

		if (FirebaseApp.getApps().isEmpty()) { // <------- Here
			FirebaseApp.initializeApp(options);
		}

		SpringApplication.run(HotelBookingApplication.class, args);
	}

}
