package com.samuelvazquez.springsecurity.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        // add our users for in memory authentication
        User.UserBuilder users = User.withDefaultPasswordEncoder();
        auth.inMemoryAuthentication()
                .withUser(users.username("john").password("test123").roles("EMPLOYEE"))
                .withUser(users.username("mary").password("test123").roles("EMPLOYEE","MANAGER"))
                .withUser(users.username("susan").password("test123").roles("EMPLOYEE","ADMIN"));
    }

    // allows configure security of web paths in application, login, logout, etc
    // for this case, to use a custom login page
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //for user authentication
                //.anyRequest().authenticated()

                //anyone can access the homepage if they have the role of employee
                .antMatchers("/").hasRole("EMPLOYEE")
                .antMatchers("/leaders/**").hasRole("MANAGER")
                .antMatchers("/systems/**").hasRole("ADMIN")
                .and()
                .formLogin()
                    .loginPage("/showMyLoginPage")
                    .loginProcessingUrl("/authenticateTheUser")
                    .permitAll()
                .and()
                .logout()
                .permitAll()
                // add a custom "access denied page"
                .and()
                .exceptionHandling().accessDeniedPage("/access-denied");
    }
}
