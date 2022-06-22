//package nashtech.ass.phuochg.coffeeshop.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
////import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import nashtech.ass.phuochg.coffeeshop.services.AccountServices;
//import nashtech.ass.phuochg.coffeeshop.servicesimpl.AccountServiceImpl;
//
//@SuppressWarnings("deprecation")
//@Configuration
//@EnableWebSecurity(debug = true )
//
//public class WebSecurityConfig1 extends WebSecurityConfigurerAdapter {
//
//	@Autowired
//	AccountServiceImpl accountServiceImpl;
//	@Autowired
//	AccountServices accountServices;
//
//	@Bean
//	public BCryptPasswordEncoder passwordEncoder() {
//
//		return new BCryptPasswordEncoder();
//	}
//
//	@Bean
//	public UserDetailsService accountServiceImpl() {
//		return (UserDetailsService) new AccountServiceImpl();
//	}
//
//	@Bean
//	public DaoAuthenticationProvider authenticationProvider() {
//		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//		authProvider.setUserDetailsService(userDetailsService());
//		authProvider.setPasswordEncoder(passwordEncoder());
//		return authProvider;
//
//	}
//
//	// ----------------------------------------------------
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.authenticationProvider(authenticationProvider());
//	}
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests().antMatchers("/admin").hasAuthority("ADMIN").antMatchers("/index")
//				.hasAuthority("CUSTUMER").antMatchers("/css/**", "/fonts/**", "/images/**", "/js/**", "/vendor/**",
//						"/libs/**", "/pro/**", "/register", "/save", "/Login/Error")
//				.permitAll().anyRequest().authenticated()
//				.and().rememberMe().key("Secret").tokenValiditySeconds(1296000);
//				//.formLogin().loginPage("/"
//	}
//
//}
