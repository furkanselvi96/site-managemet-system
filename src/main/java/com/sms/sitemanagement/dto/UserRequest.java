package com.sms.sitemanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserRequest {

    private String name;
    private String lastname;
    private Character apartmentCode;
    private Integer doorNumber;
    private String phoneNumber;

    public UserRequest(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }

}
