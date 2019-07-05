/*
 * Created on 03-07-2019 11:54 by mkocemb
 *
 * Copyright (c) 2001-2019 Unity S.A.
 * ul. Przedmiejska 6-10, 54-201 Wrocław, Poland
 * Wszelkie prawa zastrzeżone
 *
 * Niniejsze oprogramowanie jest własnością Unity S.A.
 * Wykorzystanie niniejszego oprogramowania jest możliwe tylko na podstawie
 * i w zgodzie z warunkami umowy licencyjnej zawartej z Unity S.A.
 */

package pl.unity.tutorial.marek.unknown.config.security;

//@Configuration
//@EnableWebSecurity
public class SecurityConfig {//extends WebSecurityConfigurerAdapter {
//
//	@Override
//	protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication()
//			.withUser("user1").password(passwordEncoder().encode("user1Pass")).roles("USER")
//			.and()
//			.withUser("user2").password(passwordEncoder().encode("user2Pass")).roles("USER")
//			.and()
//			.withUser("admin").password(passwordEncoder().encode("adminPass")).roles("ADMIN");
//	}
//
//	@Override
//	protected void configure(final HttpSecurity http) throws Exception {
//		http
//			.csrf().disable()
//			.authorizeRequests()
//			.antMatchers("/admin/**").hasRole("ADMIN")
//			.antMatchers("/anonymous*").anonymous()
//			.antMatchers("/login*").permitAll()
//			.anyRequest().authenticated()
//			.and()
//			.formLogin()
//			.loginPage("/login.html")//sprawdzic opcje z automatycznym login
//			.loginProcessingUrl("/users-login")
//			.defaultSuccessUrl("/", true)
//			.failureUrl("/login.html?error=true")
//		//	.failureHandler(authenticationFailureHandler())
//			.and()
//			.logout()
//			.logoutUrl("/perform_logout");
//	//		.logoutSuccessHandler(logoutSuccessHandler());
//	}
//
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
}
