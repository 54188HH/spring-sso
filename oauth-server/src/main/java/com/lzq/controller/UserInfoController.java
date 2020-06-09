package com.lzq.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @program: spring-sso
 * @description:
 * @author: liuzhenqi
 * @create: 2020-06-09 10:29
 **/
@RestController
public class UserInfoController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @RequestMapping("/user")
    public ResponseEntity<Object> getUser(Principal principal) {
        logger.info("principal:" + principal);
        return new ResponseEntity<Object>(principal, HttpStatus.OK);
    }
}

