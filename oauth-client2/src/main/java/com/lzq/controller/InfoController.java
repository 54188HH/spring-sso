package com.lzq.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

/**
 * @program: spring-sso
 * @description:
 * @author: liuzhenqi
 * @create: 2020-06-09 11:12
 **/
@Controller
public class InfoController {
    @GetMapping("/getUser")
    public ResponseEntity<Object> userPage(Principal principal) {
        //客户端认证成功后返回这个用户信息
        return  new ResponseEntity<Object>(principal, HttpStatus.OK);
    }

    @GetMapping("/")
    public String indexPage() {
        return "index";
    }
}
