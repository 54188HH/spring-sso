package com.lzq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @program: spring-sso
 * @description:
 * @author: liuzhenqi
 * @create: 2020-06-09 10:27
 **/
@Controller
public class LoginController {
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
}

