package com.mycompany.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/** 
 * Configuration class for Spring Security settings.
 * Enables web security and configures authentication and authorization rules.
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	/** 
	 * Bean that defines a BCryptPasswordEncoder for password encoding.
	 * @return BCryptPasswordEncoder instance.
	 */
	@Bean
	static BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	/** 
	 * Configures global authentication with the provided UserDetailsService and password encoder.
	 * @param auth AuthenticationManagerBuilder to configure authentication.
	 * @throws Exception if an error occurs while configuring authentication.
	 */
	@Autowired
	public void configurerGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
	
	/** 
	 * Bean that configures security filters for HTTP requests.
	 * Grants permissions for roles USER and ADMIN, including login page and logout.
	 * Handles 403 server error with a specific error page.
	 * @param http HttpSecurity instance to configure security rules.
	 * @return SecurityFilterChain instance.
	 * @throws Exception if an error occurs while configuring security.
	 */
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		http
		.authorizeHttpRequests((requests) -> requests
												.requestMatchers("/", "/clientsListRedirect/**", "/doctorsListRedirect/**", "/appointmentsListRedirect/**",
																 "/insertClient/**", "/editClient/**", "/deleteClient/**",
																 "/insertDoctor/**", "/editDoctor/**", "/deleteDoctor/**",
																 "/insertAppointment/**", "/editAppointment/**", "/deleteAppointment/**")
													.hasAnyRole("USER", "ADMIN")
				
												.requestMatchers("/departmentsListRedirect/**", "/insertDepartment/**", "/editDepartment/**", "/deleteDepartment/**",
																 "/specializationsListRedirect/**", "/insertSpecialization/**", "/editSpecialization/**", "/deleteSpecialization/**")
													.hasRole("ADMIN")
													
												.requestMatchers("/resources/**", "/static/**", "/css/**", "/js/**").permitAll()
				
												.anyRequest().authenticated()
		)
		.formLogin((form) -> form
								.loginPage("/login")
								.defaultSuccessUrl("/index", true)
								.permitAll()
		)
		.logout((logout) -> logout
								.permitAll()
		)
		.exceptionHandling(excHand -> excHand.accessDeniedPage("/errors/403"));
		
		return http.build();
		
	}

}
