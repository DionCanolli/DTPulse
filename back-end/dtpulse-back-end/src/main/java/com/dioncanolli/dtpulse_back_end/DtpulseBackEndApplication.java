package com.dioncanolli.dtpulse_back_end;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200")
@SpringBootApplication
public class DtpulseBackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(DtpulseBackEndApplication.class, args);
	}

}
