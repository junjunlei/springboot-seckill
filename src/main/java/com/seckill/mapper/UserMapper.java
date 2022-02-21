package com.seckill.mapper;

import com.seckill.entity.User;
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
     * @param id 用户ID
     * @return
     */
    @Select("select * from user where id= #{id}")
    User getUserById(@Param("id") Long id);
}
