package com.seckill;

import com.alibaba.fastjson.JSONObject;
import com.seckill.dto.LoginDTO;
import com.seckill.entity.User;
import com.seckill.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.io.Serializable;

@SpringBootTest
class SpringbootSeckillApplicationTests {

    @Autowired
    private UserService userService;

    @Resource
    private RedisTemplate<Serializable,Serializable> redisTemplate;

    @Test
    void contextLoads() {
        //userService.register(new LoginDTO("18299999999","123456"));
        //2b70b4d323ad40809eb57c27bd305018
        User user= (User) redisTemplate.opsForValue().get("2b70b4d323ad40809eb57c27bd305018");
        System.out.println(JSONObject.toJSONString(user));
    }

}
