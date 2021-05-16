package com.springsecurityoauth2.practice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

/**
 * @Description 授权服务器
 * @Author 程杰
 * @Date 2021/5/16 16:36
 * @Version 1.0
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                // 客户端ID
                .withClient("client")
                // 密钥
                .secret(passwordEncoder.encode("112233"))
                //重定向地址
                .redirectUris("http://www.baidu.com")
                // 授权范围
                .scopes("all")
                /**
                 *  授权类型
                 *  authorization_code：授权码模式
                 */
                .authorizedGrantTypes("authorization_code");


    }
}
