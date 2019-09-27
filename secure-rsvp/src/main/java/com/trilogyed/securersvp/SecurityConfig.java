package com.trilogyed.securersvp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    DataSource datasource;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder authBuilder) throws Exception {

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        authBuilder.jdbcAuthentication().
                dataSource(datasource)
                .usersByUsernameQuery("SELECT username, password, enabled FROM users WHERE username = ?")
                .authoritiesByUsernameQuery("SELECT username, authority FROM authorities WHERE username = ?")
                .passwordEncoder(passwordEncoder);
    }

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.httpBasic();
        httpSecurity.authorizeRequests()
                .mvcMatchers("/privateEvent").hasAuthority("REGISTERED_USERS")
                .mvcMatchers("/registerPrivateEvent").hasAuthority("REGISTERED_USERS")
                .mvcMatchers("/publishEvent").hasAuthority("ADMIN")
                .mvcMatchers(HttpMethod.DELETE, "/privateEvent/*").hasAuthority("ADMIN")
                .anyRequest().authenticated();

        httpSecurity.logout()
                .clearAuthentication(true)
                .deleteCookies("JSESSIONID")
                .deleteCookies("XSRF-TOKEN")
                .invalidateHttpSession(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/allDone").deleteCookies("JSESSIONID");


        httpSecurity.csrf().disable();
    }

}


