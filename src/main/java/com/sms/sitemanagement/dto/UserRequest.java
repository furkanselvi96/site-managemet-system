package com.sms.sitemanagement.dto;

import lombok.Data;

@Data
public class UserRequest {

    private String username;
    private String name;
    private String lastname;
    private Character apartmentCode;
    private Integer doorNumber;
    private String phoneNumber;

}
