package com.yangb.project.quickdev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.yangb.project.quickdev.dao")
public class QuickDevApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuickDevApplication.class, args);
    }

}
