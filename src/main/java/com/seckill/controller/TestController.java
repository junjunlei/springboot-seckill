package com.seckill.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author zhanbo
 * @Description TODO
 * @Date 2022-02-16 14:03
 * @Version 1.0
 **/
@Controller
@RequestMapping("/test")
public class TestController {

    @GetMapping("/hello")
    public String test(Model model) {
        model.addAttribute("name", "哈哈哈");
        return "hello";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("name", "哈哈哈");
        return "login";
    }
}
