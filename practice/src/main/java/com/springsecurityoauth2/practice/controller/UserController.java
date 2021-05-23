package com.springsecurityoauth2.practice.controller;

import io.jsonwebtoken.Jwts;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;

/**
 * @Description
 * @Author 程杰
 * @Date 2021/5/16 16:48
 * @Version 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {


//    @RequestMapping("/getCurrentUser")
//    public Object getCurrentUser(Authentication authentication){
//        return authentication.getPrincipal();
//    }

    @RequestMapping("/getCurrentUser")
    public Object getCurrentUser(Authentication authentication, HttpServletRequest request){
        String header = request.getHeader("Authorization");
        String token = header.substring(header.lastIndexOf("bearer") + 7);
        return Jwts.parser()
                .setSigningKey("test_key".getBytes(StandardCharsets.UTF_8))
                .parseClaimsJws(token)
                .getBody();
    }


}
