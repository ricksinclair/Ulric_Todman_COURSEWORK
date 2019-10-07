package com.company.UlricTodmanU1Capstone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Autowired
    public void  configAuthentication(AuthenticationManagerBuilder authBuilder) throws Exception{
        PasswordEncoder encoder = new BCryptPasswordEncoder();

        authBuilder.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("SELECT username, password, enabled FROM users WHERE username = ?")
                .authoritiesByUsernameQuery("SELECT username, authority FROM authorities WHERE username = ?")
                .passwordEncoder(encoder);
    }


    public void configure(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.httpBasic();

        httpSecurity.authorizeRequests()
                .mvcMatchers("/loggedin").authenticated()
                .mvcMatchers(HttpMethod.PUT, "/Consoles").hasAuthority("ROLE_STAFF")
                .mvcMatchers(HttpMethod.PUT, "/Game").hasAuthority("ROLE_STAFF")
                .mvcMatchers(HttpMethod.PUT, "TShirt").hasAuthority("ROLE_STAFF")
                .mvcMatchers(HttpMethod.POST, "/Consoles").hasAuthority("ROLE_MANAGER")
                .mvcMatchers(HttpMethod.POST, "/Game").hasAuthority("ROLE_MANAGER")
                .mvcMatchers(HttpMethod.POST, "/TShirt").hasAuthority("ROLE_MANAGER")
                .mvcMatchers(HttpMethod.DELETE, "/Consoles").hasAuthority("ROLE_ADMIN")
                .mvcMatchers(HttpMethod.DELETE, "/Game").hasAuthority("ROLE_ADMIN")
                .mvcMatchers(HttpMethod.DELETE, "/TShirt").hasAuthority("ROLE_ADMIN")
                .anyRequest().permitAll();

        httpSecurity
                .logout()
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/allDone")
                .deleteCookies("JSESSIONID")
                .deleteCookies("XSRF-TOKEN")
                .invalidateHttpSession(true);

        httpSecurity
                .csrf()
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());

    }
}
