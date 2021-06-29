package com.gnsym.config;

//@Configuration
//@EnableWebSecurity
public class SpringSecurityConfigure /* extends WebSecurityConfigurerAdapter */ {
	/*
	 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
	 * Exception {
	 * auth.inMemoryAuthentication().withUser("gnsym").password("123456"); //
	 * auth.inMemoryAuthentication().withUser("${spring.security.user}").password(
	 * "${spring.security.user}").roles("ADMIN"); //
	 * auth.inMemoryAuthentication().withUser("${spring.security.user}").password(
	 * "${spring.security.user}").roles("USER"); }
	 * 
	 * @Override protected void configure(HttpSecurity http) throws Exception {
	 * http.csrf().disable();
	 * http.authorizeRequests().anyRequest().fullyAuthenticated().and().httpBasic();
	 * }
	 * 
	 * private CsrfTokenRepository csrfTokenRepository() {
	 * HttpSessionCsrfTokenRepository repository = new
	 * HttpSessionCsrfTokenRepository();
	 * repository.setSessionAttributeName("_csrf"); return repository; }
	 * 
	 * @Bean public static NoOpPasswordEncoder passwordEncoder() { return
	 * (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	 * 
	 * }
	 */
}
