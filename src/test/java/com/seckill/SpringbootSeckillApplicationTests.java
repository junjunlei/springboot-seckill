package com.seckill;

import com.seckill.service.UserService;
import com.seckill.util.UserUtil;
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

    @Autowired
    private UserUtil util;

    @Resource
    private RedisTemplate<Serializable,Serializable> redisTemplate;

    @Test
    void contextLoads() throws Exception {
        //userService.register(new LoginDTO("18299999999","123456"));
        //2b70b4d323ad40809eb57c27bd305018
        //User user= (User) redisTemplate.opsForValue().get("2b70b4d323ad40809eb57c27bd305018");
        //System.out.println(JSONObject.toJSONString(user));
        util.createUser(5000);
    }

}
