package com.seckill.controller;

import com.alibaba.fastjson.JSONObject;
import com.seckill.dto.LoginDTO;
import com.seckill.entity.User;
import com.seckill.global.Result;
import com.seckill.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    private static final Logger log = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserService userService;

    @GetMapping
    public String toDoLogin() {
        return "login1";
    }

    @GetMapping("/info")
    public String userInfo(User user) {
        log.info("当前用户信息为：{}",JSONObject.toJSONString(user));
        return "login1";
    }

    @PostMapping("/do")
    @ResponseBody
    public Result doLogin(HttpServletResponse response, LoginDTO loginDTO) {
        return Result.success(userService.login(response, loginDTO));
    }
}
