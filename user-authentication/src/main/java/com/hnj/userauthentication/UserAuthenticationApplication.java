package com.hnj.userauthentication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient //It inherits from @EnableDiscoveryClient.
public class UserAuthenticationApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserAuthenticationApplication.class, args);
    }
}
