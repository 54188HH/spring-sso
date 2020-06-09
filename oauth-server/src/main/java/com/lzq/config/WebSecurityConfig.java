package com.lzq.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @program: spring-sso
 * @description:
 * @author: liuzhenqi
 *  @Configuration 让这个类成为了一个配置类, @Order(1) 这个注解是优先级，使用优先级来加载。
 * @create: 2020-06-09 10:21
 **/
@Configuration
@Order(1)
public class WebSecurityConfig  extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /**
         * http.requestMatchers() 这个方法下配置的就是security
         * 接收以什么样的请求,我们这里只接受/login和/oauth/authorize的请求
         */
        http.requestMatchers()
                .antMatchers("/login")
                .antMatchers("/oauth/authorize")
                .and()
                //除了以上请求所有的请求都需要身份认证才能访问。
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                //form表单登陆默认登陆页面是/login，任何人都能访问,关闭csrf的保护。
                .formLogin().loginPage("/login").permitAll()
                .and().csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //这里采用的是AuthenticationManagerBuilder 允许内存验证，这里我添加了一个用户名为admin
        // 密码是 123456，角色是ADMIN的 一个用户 来模拟数据库查询的用户信息。

        //使用内存模拟数据库查询的用户
        auth.inMemoryAuthentication() //内存认证
                .withUser("admin")//admin 内存认证用户名
                .password(passwordEncoder().encode("123456"))//被加密的123456密码
                .roles("ADMIN");//ROLE_ADMIN的角色
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        //PasswordEncoder 是Spring 官方提供的一个md5 密码加密器,一般用于密码的加密。
        return new BCryptPasswordEncoder();
    }
}
