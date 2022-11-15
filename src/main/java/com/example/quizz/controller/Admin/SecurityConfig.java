package com.example.quizz.controller.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {

        httpSecurity

                // URL autorizations:
                .authorizeRequests()
                // The order of the rules matters and the more specific rules should go first.
                // ne pas oublier le / devant les URLs
                .antMatchers("/", "/index.html").permitAll()
                .antMatchers("/", "/user/registration").permitAll()
                .antMatchers("/", "/index.html", "/api/user").permitAll()
                .antMatchers("/", "/index.html", "/api/user/login").permitAll()

                .anyRequest().authenticated()

                // Authentication mode:
                .and().formLogin()           //  redirect to /login HTML page and then to the resource after successfull authentication

                // Authentication mode:
                .and().httpBasic()        // for web API auth

                // disable csrf Protection:
                .and().csrf().disable()

        ;
    }

    @Autowired
    private DataSource dataSource;

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().passwordEncoder(getPasswordEncoder()).dataSource(dataSource)
                .usersByUsernameQuery("select email, password, enabled from users where email=?")
                .authoritiesByUsernameQuery("select email, role from users where email=?");
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

}