package com.sms.sitemanagement.repository;

import com.sms.sitemanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserJpaRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

    List<User> findByApartmentCode(Character character);

    User findByApartmentCodeAndDoorNumber(Character apartmentCode, Integer doorNumber);

    List<User> findByName(String name);

    List<User> findByLastname(String lastname);

    List<User> findByNameAndLastnameAndApartmentCodeAndDoorNumber(String name, String lastname, Character apartmentCode, Integer doorNumber);

    List<User> findByNameAndLastnameAndApartmentCode(String name, String lastname, Character apartmentCode);
}
