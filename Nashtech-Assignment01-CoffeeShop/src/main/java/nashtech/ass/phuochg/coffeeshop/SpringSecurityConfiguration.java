package nashtech.ass.phuochg.coffeeshop;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
 
@EnableWebSecurity
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {
 
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
 
  }
 
  @Override
  protected void configure(HttpSecurity http) throws Exception {
  }
 
  @Override
  public void configure(WebSecurity web) throws Exception {
  }
}