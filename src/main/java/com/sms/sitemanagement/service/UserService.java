package com.sms.sitemanagement.service;

import com.sms.sitemanagement.dto.UserRequest;
import com.sms.sitemanagement.model.User;
import com.sms.sitemanagement.repository.UserJpaRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

    public User addUser(UserRequest userRequest) {
        User user = new User();
        user.setName(userRequest.getName());
        user.setLastname(userRequest.getLastname());
        user.setApartmentCode(userRequest.getApartmentCode());
        user.setDoorNumber(userRequest.getDoorNumber());
        user.setPhoneNumber(userRequest.getPhoneNumber());

        return userJpaRepository.save(user);
    }

    public User updateUser(Long userId, UserRequest userRequest) {
        Optional<User> optionalUser = userJpaRepository.findById(userId);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setName(userRequest.getName());
            user.setLastname(userRequest.getLastname());
            user.setApartmentCode(userRequest.getApartmentCode());
            user.setDoorNumber(userRequest.getDoorNumber());
            user.setPhoneNumber(userRequest.getPhoneNumber());

            return userJpaRepository.save(user);
        } else {
            return null;
        }
    }

    public List<User> getUsers() {
        return userJpaRepository.findAll();
    }

    public User getUser(Long userId) {
        return userJpaRepository.findById(userId).orElse(null);
    }

    public boolean deleteUser(Long userId) {
        if (userJpaRepository.existsById(userId)) {
            userJpaRepository.deleteById(userId);
            return true;
        }
        return false;
    }

    public List<User> getApartmentUsers(Character apartmentCode) {
        return userJpaRepository.findByApartmentCode(apartmentCode);
    }

    public List<User> getFilteredUsers(String name, String lastname, Character apartmentCode, Integer doorNumber) {
        User user = new User();
        user.setName(name);
        user.setLastname(lastname);
        user.setApartmentCode(apartmentCode);
        user.setDoorNumber(doorNumber);

        ExampleMatcher userMatcher = ExampleMatcher.matchingAll()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)
                .withIgnoreCase();

        Example<User> example = Example.of(user, userMatcher);
        return userJpaRepository.findAll(example);
    }

}
