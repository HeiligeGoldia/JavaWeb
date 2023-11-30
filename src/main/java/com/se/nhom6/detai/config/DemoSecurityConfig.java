package com.se.nhom6.detai.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource securityDataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/resources/**").permitAll()
                .antMatchers("/getimage/**").permitAll()
                .antMatchers("/").permitAll().antMatchers("/getProductsByName/**").permitAll().
                antMatchers("/product_detail").permitAll()
				.antMatchers("/products/**").hasRole("MANAGER")
                .antMatchers("/orders/**").hasRole("MANAGER")
                .anyRequest().authenticated()
                .and().formLogin()
                .loginPage("/showMyLoginPage")
                .loginProcessingUrl("/authenticateTheUser")
                .successHandler(new MyAuthenticationSuccessHandler())
                .permitAll()
                .and().logout()
                .permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/accessdenied")
                .and().csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(securityDataSource);
//		auth.jdbcAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance());
//		User.UserBuilder user = User.withDefaultPasswordEncoder();
//		auth.inMemoryAuthentication()
//				.withUser(user.username("goldia").password("123").roles("USER"))
//				.withUser(user.username("kaito").password("123").roles("MANAGER"));
    }

}