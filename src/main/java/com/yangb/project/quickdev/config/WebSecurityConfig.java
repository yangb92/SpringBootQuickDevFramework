package com.yangb.project.quickdev.config;

import com.yangb.project.quickdev.config.comment.CustomAuthenticationProvider;
import com.yangb.project.quickdev.config.comment.SecurityHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;

/**
 * @author Created by yangb on 2020/4/14
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private CustomAuthenticationProvider customAuthenticationProvider;

    @Resource
    private SecurityHandler securityHandler;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(customAuthenticationProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/admin/**").hasAuthority("ROLE_ADMIN")
                    .anyRequest().authenticated()
                .and()
                .csrf().disable()
                .formLogin()
                    .loginProcessingUrl("/login")
                    .successHandler(securityHandler::onAuthenticationSuccess)
                    .failureHandler(securityHandler::onAuthenticationFailure)
                .permitAll()
                .and()
                .logout()
                    .logoutUrl("/logout")
                    .clearAuthentication(true)
                    .deleteCookies("JSESSIONID")
                    .invalidateHttpSession(true)
                    .logoutSuccessHandler(securityHandler::onLogoutSuccess)
                    .permitAll()
                .and()
                .exceptionHandling().authenticationEntryPoint(securityHandler::commence);
    }
}
