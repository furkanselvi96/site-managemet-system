package com.sms.sitemanagement.dto;

import lombok.Data;

@Data
public class UserRequest {

    private String name;
    private String lastname;
    private Character apartmentCode;
    private String doorNumber;
    private String phoneNumber;

}
