package com.sms.sitemanagemet.service;

import com.sms.sitemanagemet.repository.UserJpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    private final UserJpaRepository userJpaRepository;

    public UserService(UserJpaRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }

    public String test() {
        return UUID.randomUUID().toString();
    }

//    public
}
