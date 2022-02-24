package com.seckill.entity;

import java.io.Serializable;

/**
 * 用户信息
 */
public class User implements Serializable {

    private static final long serialVersionUID = -4600691147960097476L;
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 密码，双md5加密
     */
    private String password;

    /**
     * 盐
     */
    private String salt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
