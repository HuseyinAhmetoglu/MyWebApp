package com.myWebApiServer.myWebApi.service;

import com.myWebApiServer.myWebApi.exception.ResourceNotFoundException;
import com.myWebApiServer.myWebApi.model.User;
import com.myWebApiServer.myWebApi.security.CustomUserDetail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserService userService;

    public UserDetailsServiceImpl(UserService userService) {
        this.userService = userService;
    }

    private static final Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        logger.debug("Entering in loadUserByUsername Method...");
        User user = userService.getByUsername(username).orElseThrow(() -> {
            logger.error("Username not found: " + username);
            return new ResourceNotFoundException("could not found user..!!");
        });
        logger.info("User Authenticated Successfully..!!!");
        return new CustomUserDetail(user);
    }
}
