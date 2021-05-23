package com.login.client.Controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author 程杰
 * @Date 2021/5/23 16:19
 * @Version 1.0
 */
@RestController
@RequestMapping("/user")
public class ClientController {

    @RequestMapping("/getCurrentUser")
    public Object getCurrentUser(Authentication authentication){
        return authentication;
    }

}
