package com.hnj.smsservice;
import com.hnj.smsservice.repositories.ISmsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
						    // inherits from @EnableDiscoveryClient.
public class SmsServiceApplication implements CommandLineRunner {

	@Autowired
	private ISmsRepository iSmsRepository;

	public static void main(String[] args) {
		SpringApplication.run(SmsServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
        //iSmsRepository.save(new Sms("hello user, we would like to thank you.", "21/11/2018"));
	}
}
