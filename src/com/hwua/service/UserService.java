package com.hwua.service;

import com.hwua.entity.User;

public interface UserService {
    //注册用户
    public int  insertUser(User user);
    //用户登录
    public String selectUserByUsername(String user_username,String user_password);
}
