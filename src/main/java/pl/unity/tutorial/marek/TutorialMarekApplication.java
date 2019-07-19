package pl.unity.tutorial.marek;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@EnableTransactionManagement
public class TutorialMarekApplication {

	public static void main(String[] args) {

		SpringApplication.run(TutorialMarekApplication.class, args);
	}
}
