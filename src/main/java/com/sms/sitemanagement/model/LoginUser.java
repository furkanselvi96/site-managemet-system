package com.sms.sitemanagement.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "login_user")
@ToString
@RequiredArgsConstructor
public class LoginUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loginUserId;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoginUser loginUser = (LoginUser) o;
        return Objects.equals(loginUserId, loginUser.loginUserId) && Objects.equals(username, loginUser.username) && Objects.equals(password, loginUser.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(loginUserId, username, password);
    }
}
