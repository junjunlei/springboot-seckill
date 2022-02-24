package com.seckill.service;

import com.seckill.dto.LoginDTO;
import com.seckill.entity.User;

import javax.servlet.http.HttpServletResponse;

/**
 * @Author zhanbo
 * @Description TODO
 * @Date 2022-02-21 19:16
 * @Version 1.0
 **/
public interface UserService {
    void login(HttpServletResponse response, LoginDTO loginDTO);

    void register(LoginDTO loginDTO);

    User getUserInfoByCookie(HttpServletResponse response,String cookie);
}
