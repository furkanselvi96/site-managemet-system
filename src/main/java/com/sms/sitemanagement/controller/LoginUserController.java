package com.sms.sitemanagement.controller;

import com.sms.sitemanagement.dto.LoginUserRequest;
import com.sms.sitemanagement.model.LoginUser;
import com.sms.sitemanagement.service.LoginUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/login")
public class LoginUserController {

    @Autowired
    private LoginUserService loginUserService;

    @PostMapping
    public ResponseEntity<String> createLoginUser(@RequestBody LoginUserRequest loginUserRequest) {
        boolean creationResult = loginUserService.createLoginUser(loginUserRequest);

        if (creationResult) {
            return ResponseEntity.ok("User created successfully.");
        } else {
            return ResponseEntity.badRequest().body("User not created.Username already exists.");
        }
    }

    @GetMapping
    public ResponseEntity<List<LoginUser>> getAllLoginUsers() {
        List<LoginUser> loginUsers = loginUserService.getAllLoginUsers();
        return ResponseEntity.ok(loginUsers);
    }

    @GetMapping("/{username}")
    public ResponseEntity<LoginUser> getLoginUserByUsername(@PathVariable String username) {
        LoginUser loginUser = loginUserService.getLoginUserById(username);
        return ResponseEntity.ok(loginUser);
    }

    @PutMapping("/{username}")
    public ResponseEntity<String> updateLoginUser(@PathVariable String username, @RequestBody LoginUserRequest loginUserRequest) {
        boolean updatedResult = loginUserService.updateLoginUser(username, loginUserRequest);

        if (updatedResult) {
            return ResponseEntity.ok("User updated.");
        } else {
            return ResponseEntity.badRequest().body("User not updated.");
        }
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<String> deleteLoginUser(@PathVariable String username) {
        boolean deleteResult = loginUserService.deleteLoginUser(username);

        if (deleteResult) {
            return ResponseEntity.ok("User deleted.");
        } else {
            return ResponseEntity.badRequest().body("User not deleted.");
        }
    }
}

