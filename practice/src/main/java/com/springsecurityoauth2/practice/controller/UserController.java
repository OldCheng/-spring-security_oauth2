package com.springsecurityoauth2.practice.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author 程杰
 * @Date 2021/5/16 16:48
 * @Version 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {


    @RequestMapping("/getCurrentUser")
    public Object getCurrentUser(Authentication authentication){
        return authentication.getPrincipal();
    }

}
