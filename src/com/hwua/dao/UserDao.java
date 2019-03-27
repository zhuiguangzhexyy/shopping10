package com.hwua.dao;

import com.hwua.entity.User;

public interface UserDao {
    //注册用户
    public int  insertUser(User user);
    //用户登录
    public User selectUserByUsername(String user_username);

}
