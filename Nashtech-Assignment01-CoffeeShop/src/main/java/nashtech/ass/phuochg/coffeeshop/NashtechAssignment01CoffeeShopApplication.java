package nashtech.ass.phuochg.coffeeshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@EnableWebSecurity
public class NashtechAssignment01CoffeeShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(NashtechAssignment01CoffeeShopApplication.class, args);
	}

	@Bean
	public WebMvcConfigurerAdapter corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/products").allowedOrigins("http://localhost:9000");
			}
		};
	}
}