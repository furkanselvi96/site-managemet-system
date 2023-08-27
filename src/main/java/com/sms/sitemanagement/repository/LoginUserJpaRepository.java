package com.sms.sitemanagement.repository;

import com.sms.sitemanagement.model.LoginUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginUserJpaRepository extends JpaRepository<LoginUser, String> {

    LoginUser findByUsername(String username);

    boolean existsByUsername(String username);
}
