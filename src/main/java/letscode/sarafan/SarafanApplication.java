package letscode.sarafan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.sentry.Sentry;

@SpringBootApplication
public class SarafanApplication {

	public static void main(String[] args) {
		Sentry.capture("Application started");
		SpringApplication.run(SarafanApplication.class, args);
	}
}
