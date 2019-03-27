package com.hwua.serviceImpl;

import com.hwua.dao.UserDao;
import com.hwua.entity.User;
import com.hwua.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    @Override
    @Transactional
    public int insertUser(User user) {
        int number = userDao.insertUser(user);
        return number;
    }

    @Override
    public String selectUserByUsername(String user_username, String user_password) {
        User user = userDao.selectUserByUsername(user_username);
        if(user==null){
            return "用户名不存在";
        }else if(user.getUser_password().equals(user_password)){
           return "登录成功";
        }else{
            return "密码错误";
        }

    }
}
