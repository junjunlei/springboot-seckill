package com.seckill.service.impl;

import com.seckill.dto.LoginDTO;
import com.seckill.entity.User;
import com.seckill.mapper.UserMapper;
import com.seckill.service.UserService;
import com.seckill.util.Md5Util;
import com.seckill.util.UUIDUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

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

    @Resource
    private RedisTemplate<Serializable, Serializable> redisTemplate;

    @Override
    public void login(HttpServletResponse response, LoginDTO loginDTO) {
        if (Objects.isNull(loginDTO)) {
            throw new RuntimeException("用户名密码不能为空");
        }
        String mobile = loginDTO.getMobile();
        String password = loginDTO.getPassword();
        User userDb = userMapper.getUserById(mobile);
        if (Objects.isNull(userDb)) {
            throw new RuntimeException("用户名不存在");
        }
        String passwordDb = userDb.getPassword();
        String encryptPassword = Md5Util.encryptCode(password, userDb.getSalt());
        if (!passwordDb.equals(encryptPassword)) {
            throw new RuntimeException("密码错误");
        }
        //生成cookie
        String userCookie = UUIDUtil.uuid();
        addCookie(response, userDb, userCookie);
    }

    private void addCookie(HttpServletResponse response, User userDb, String userCookie) {
        redisTemplate.opsForValue().set(userCookie, userDb, 3600 * 24 * 2, TimeUnit.SECONDS);
        Cookie cookie = new Cookie("user_cookie", userCookie);
        cookie.setMaxAge(3600 * 24 * 2);
        cookie.setPath("/");
        response.addCookie(cookie);
        response.addCookie(cookie);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public void register(LoginDTO loginDTO) {
        if (Objects.isNull(loginDTO)) {
            throw new RuntimeException("用户名密码不能为空");
        }
        //手机号
        String mobile = loginDTO.getMobile();
        //密码
        //String password = loginDTO.getPassword();
        //随机盐
        String salt = UUIDUtil.uuid();
        String newPassWord = Md5Util.encryptCode("67cbf38191f965aa070cd90b85b4b772", salt);
        User user = new User();
        user.setMobile(mobile);
        user.setPassword(newPassWord);
        user.setSalt(salt);
        userMapper.insert(user);
    }

    @Override
    public User getUserInfoByCookie(HttpServletResponse response, String cookie) {
        if (StringUtils.isBlank(cookie)) {
            return null;
        }
        User user = (User) redisTemplate.opsForValue().get(cookie);
        //延长有效期
        if (user != null) {
            addCookie(response, user, cookie);
        }
        return user;
    }
}
