package com.qa.community.springtesting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringTestingCommunityApplication {

    public static void main(String[] args) {
        ApplicationContext beanbag = SpringApplication.run(SpringTestingCommunityApplication.class, args);
    }

}
