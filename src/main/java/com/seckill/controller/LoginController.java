package com.seckill.controller;

import com.seckill.dto.LoginDTO;
import com.seckill.global.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * @Author zhanbo
 * @Description TODO
 * @Date 2022-02-21 17:25
 * @Version 1.0
 **/
@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping
    public String toDoLogin() {
        return "login1";
    }

    @PostMapping
    @ResponseBody
    public Result doLogin(HttpServletResponse response, LoginDTO loginDTO) {

        return Result.success(true);
    }
}
