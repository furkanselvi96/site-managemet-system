package com.sms.sitemanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api")
@SpringBootApplication
public class SiteManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(SiteManagementSystemApplication.class, args);
    }

}
