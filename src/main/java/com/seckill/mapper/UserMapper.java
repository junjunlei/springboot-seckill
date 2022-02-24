package com.seckill.mapper;

import com.seckill.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @Author zhanbo
 * @Description 用户信息mapper
 * @Date 2022-02-17 16:26
 * @Version 1.0
 **/
@Mapper
public interface UserMapper {
    /**
     * 根据id获取用户信息
     *
     * @param mobile 手机号
     * @return
     */
    @Select("select * from user where mobile= #{mobile}")
    User getUserById(@Param("mobile") String mobile);

    @Insert("insert into user (mobile,password,salt) values (#{mobile},#{password},#{salt})")
    int insert(User user);
}
