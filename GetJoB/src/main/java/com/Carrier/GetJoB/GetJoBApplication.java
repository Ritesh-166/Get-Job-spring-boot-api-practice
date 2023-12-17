package com.Carrier.GetJoB;

import com.Carrier.GetJoB.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class GetJoBApplication {


	public static void main(String[] args) {
		SpringApplication.run(GetJoBApplication.class, args);
	}



}
