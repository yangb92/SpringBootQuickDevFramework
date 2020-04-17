package com.yangb.project.quickdev.config;

import com.alibaba.fastjson.JSON;
import com.yangb.project.quickdev.common.ResultVo;
import com.yangb.project.quickdev.config.comment.CustomAuthenticationProvider;
import com.yangb.project.quickdev.config.comment.RedisSecurityContextRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.context.SecurityContextPersistenceFilter;

import javax.annotation.Resource;
import java.io.PrintWriter;

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
    RedisSecurityContextRepository redisSecurityContextRepository;

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
                    .successHandler((request, response, authentication) -> {
                        response.setContentType("application/json;charset=utf-8");
                        PrintWriter out = response.getWriter();
                        out.write(JSON.toJSONString(ResultVo.makeSuccess("登陆成功")));
                        out.flush();
                        out.close();
                    })
                    .failureHandler((request, response, exception) -> {
                        response.setContentType("application/json;charset=utf-8");
                        PrintWriter out = response.getWriter();
                        ResultVo result = ResultVo.makeFailed(exception.getMessage());
                        out.write(JSON.toJSONString(result));
                        out.flush();
                        out.close();
                    })
                .permitAll()
                .and()
                .logout()
                    .logoutUrl("/logout")
                    .clearAuthentication(true)
                    .deleteCookies("JSESSIONID")
                    .invalidateHttpSession(true)
                    .logoutSuccessHandler((request, response, authentication) -> {
                        redisSecurityContextRepository.cleanContext(request); //清除缓存会话
                        response.setContentType("application/json;charset=utf-8");
                        PrintWriter out = response.getWriter();
                        ResultVo result = ResultVo.makeSuccess("退出成功");
                        out.write(JSON.toJSONString(result));
                        out.flush();
                        out.close();
                    })
                    .permitAll()
                .and()
                .exceptionHandling().authenticationEntryPoint((request, response, authException) -> {
                    response.setContentType("application/json;charset=utf-8");
                    PrintWriter out = response.getWriter();
                    out.write(JSON.toJSONString(ResultVo.makeFailed("请登陆后访问")));
                    out.flush();
                    out.close();
                })
                .and()
                .securityContext()
                    .securityContextRepository(redisSecurityContextRepository);
    }
}
