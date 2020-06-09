package com.lzq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @program: spring-sso
 * @description:
 * @author: liuzhenqi
 * @create: 2020-06-09 11:17
 **/
@SpringBootApplication
public class OuthServer {
    public static void main(String[] args) {
        SpringApplication.run(OuthServer.class,args);
    }
}
