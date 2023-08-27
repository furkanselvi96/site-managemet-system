package com.sms.sitemanagement.service;

import com.sms.sitemanagement.dto.LoginUserRequest;
import com.sms.sitemanagement.model.LoginUser;
import com.sms.sitemanagement.repository.LoginUserJpaRepository;
import com.sms.sitemanagement.repository.UserJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginUserService {

    private final LoginUserJpaRepository loginUserJpaRepository;

    private final UserJpaRepository userJpaRepository;


    public LoginUserService(LoginUserJpaRepository loginUserJpaRepository, UserJpaRepository userJpaRepository) {
        this.loginUserJpaRepository = loginUserJpaRepository;
        this.userJpaRepository = userJpaRepository;
    }

    public boolean createLoginUser(LoginUserRequest loginUserRequest) {
        boolean isExistUsername = userJpaRepository.existsByUsername(loginUserRequest.getUsername());
        if (!isExistUsername) {
            LoginUser newUser = new LoginUser();
            newUser.setUsername(loginUserRequest.getUsername());
            newUser.setPassword(loginUserRequest.getPassword());
            loginUserJpaRepository.save(newUser);
            return true;
        }
        return false;
    }

    public List<LoginUser> getAllLoginUsers() {
        return loginUserJpaRepository.findAll();
    }

    public LoginUser getLoginUserById(String username) {
        return loginUserJpaRepository.findByUsername(username);
    }

    public boolean updateLoginUser(String username, LoginUserRequest loginUserRequest) {
        if (username != null && !username.isEmpty()) {
            LoginUser loginUser = loginUserJpaRepository.findByUsername(username);
            loginUser.setUsername(loginUserRequest.getUsername());
            loginUser.setPassword(loginUserRequest.getPassword());

            loginUserJpaRepository.save(loginUser);
            return true;
        }
        return false;
    }

    public boolean deleteLoginUser(String username) {
        LoginUser loginUser = loginUserJpaRepository.findByUsername(username);

        if (loginUser != null) {
            loginUserJpaRepository.delete(loginUser);
            return true;
        }
        return false;
    }
}
