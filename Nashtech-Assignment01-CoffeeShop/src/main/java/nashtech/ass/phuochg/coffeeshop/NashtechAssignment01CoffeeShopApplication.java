package nashtech.ass.phuochg.coffeeshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class NashtechAssignment01CoffeeShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(NashtechAssignment01CoffeeShopApplication.class, args);
	}
}