package com.example.gasWaterUsageMonitoring.configuration;

import com.example.gasWaterUsageMonitoring.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfigurerImpl extends WebSecurityConfigurerAdapter {
    private final UserService userService;
    private final PasswordEncoder encoder;

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
                .mvcMatchers("/api/measurement/**").hasAnyRole("USER")
                .mvcMatchers("/api/admin/**").hasRole("ADMIN")
                .and()
                .formLogin()
                .and()
                .csrf().disable() // disabling CSRF will allow sending POST request using Postman;
                .httpBasic();

        //http.headers().frameOptions().sameOrigin(); // needed to prevent a Whitelable page error when logging in to the console
        http.headers().frameOptions().disable();
    }
}
