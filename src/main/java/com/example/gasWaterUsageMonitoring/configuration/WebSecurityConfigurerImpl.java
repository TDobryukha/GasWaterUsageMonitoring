package com.example.gasWaterUsageMonitoring.configuration;

import com.example.gasWaterUsageMonitoring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfigurerImpl extends WebSecurityConfigurerAdapter {
    UserService userService;
    PasswordEncoder encoder;

    @Autowired
    public WebSecurityConfigurerImpl(UserService userService, PasswordEncoder encoder) {
        this.userService = userService;
        this.encoder = encoder;
    }

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService)
                .passwordEncoder(encoder);
        auth.inMemoryAuthentication()
                .withUser("Admin").password(encoder.encode("123")).roles("ADMIN")
                .and().withUser("User").password(encoder.encode("123")).roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .mvcMatchers("/registration").permitAll()
                .antMatchers("/h2-console/**").hasRole("ADMIN")
                .mvcMatchers("/api/measurement/add").hasAnyRole("USER")
                .mvcMatchers("/api/measurement/history").hasAnyRole("ADMIN", "USER")
                .mvcMatchers("/api/user/**", "/api/measurement/**").hasRole("ADMIN")
                .and()
                .formLogin()
                .and()
                .csrf().disable() // disabling CSRF will allow sending POST request using Postman;
                .httpBasic();

        //http.headers().frameOptions().sameOrigin(); // needed to prevent a Whitelable page error when logging in to the console
        http.headers().frameOptions().disable();
    }
}
