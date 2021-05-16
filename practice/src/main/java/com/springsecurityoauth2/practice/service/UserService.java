package com.springsecurityoauth2.practice.service;

import com.springsecurityoauth2.practice.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author 程杰
 * @Date 2021/5/16 16:19
 * @Version 1.0
 */
@Service
public class UserService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String password = passwordEncoder.encode("123456");
        return new User(username, password, AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }

}
