package hh.swd20.filmbase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import hh.swd20.filmbase.webcontroller.UserDetailServiceImpl;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailServiceImpl userDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests().antMatchers("/h2-console/**").permitAll()
          .and().csrf().ignoringAntMatchers("/h2-console/**", "/films/**", "/genres/**")
          .and().headers().frameOptions().sameOrigin()
          .and()
		.authorizeRequests().antMatchers("/css/**", "/", "/filmlist", "/films/**", "/genres/**").permitAll()
		  .antMatchers("/edit/{id}", "/delete/{id}", "/deletegenre/{id}").hasAuthority("ADMIN")    
          .anyRequest().authenticated()
          .and()
        .formLogin()
          .loginPage("/login")
          .defaultSuccessUrl("/filmlist")
          .permitAll()
          .and()
		.logout()
          .permitAll();
	}
	
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }
}