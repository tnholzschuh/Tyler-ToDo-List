package com.tylerholzschuh.todoapp.config;

import com.tylerholzschuh.todoapp.services.ToDoUserDetailsService;
import com.tylerholzschuh.todoapp.services.ToDoUserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class ToDoSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    ToDoUserDetailsService toDoUserDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/register-form").permitAll()
                                .antMatchers("/register").permitAll();

        http.authorizeRequests().anyRequest().authenticated();

        http.formLogin()
                .loginPage("/login-page")
                .loginProcessingUrl("/authenticate-user")
                .successHandler(new ToDoAuthenticationSuccessHandler())
                .permitAll();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(toDoUserDetailsService);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }
}
