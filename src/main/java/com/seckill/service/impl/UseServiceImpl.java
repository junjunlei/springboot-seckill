package com.seckill.service.impl;

import com.seckill.dto.LoginDTO;
import com.seckill.entity.User;
import com.seckill.mapper.UserMapper;
import com.seckill.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;
import java.util.Random;
import java.util.UUID;

/**
 * @Author zhanbo
 * @Description TODO
 * @Date 2022-02-21 19:17
 * @Version 1.0
 **/
@Service
public class UseServiceImpl implements UserService {


    @Autowired
    private UserMapper userMapper;

    @Override
    public void login(HttpServletResponse response, LoginDTO loginDTO) {
        if (Objects.isNull(loginDTO)) {
            throw new RuntimeException("用户名密码不能为空");
        }
        String mobile = loginDTO.getMobile();
        String password = loginDTO.getPassword();
        User userDb = userMapper.getUserById(Long.parseLong(mobile));
        if (Objects.isNull(userDb)) {
            throw new RuntimeException("用户名不存在");
        }
        String passwordDb = userDb.getPassword();
        if (!passwordDb.equals(password)) {
            throw new RuntimeException("密码错误");
        }
        //生成cookie
        String userCookie = UUID.randomUUID().toString();
        Cookie cookie = new Cookie("user_cookie", userCookie);
        cookie.setMaxAge(3600 * 24 * 2);
        cookie.setPath("/");
        response.addCookie(cookie);
        response.addCookie(cookie);
    }
}
