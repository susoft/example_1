package com.soo.temp;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /*@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
          .inMemoryAuthentication()
          .withUser("admin").password("password").roles("ADMIN");
    }*/
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .anyRequest()
            .permitAll()
            .and().csrf().disable()
        	/*.headers()
            .addHeaderWriter(new StaticHeadersWriter("X-Content-Security-Policy","script-src 'self'"))
            .frameOptions().disable()*/
            ;
    }
    

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/h2-console/**");
	}
    
    /*@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
          .httpBasic().and()
          .authorizeRequests()
          .antMatchers("/").hasRole("ADMIN")
          .anyRequest().authenticated();
    }*/
}
