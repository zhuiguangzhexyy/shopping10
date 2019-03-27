package com.hwua.controller;

import com.hwua.entity.User;
import com.hwua.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping(value = "/register", produces = "text/html; charset=UTF-8" )
   public String register(String userName,String passWord,Integer sex,String birthday,String identity,String email,String mobile,String address ){
        User user=new User(null,userName,passWord,sex,birthday,identity,email,mobile,address );
        int number = userService.insertUser(user);
        if(number==1){
            return "index";
        }else{
            return "register";
        }


    }
    //用户登录
    @RequestMapping(value = "/login",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String login(String user_username, String user_userpassword, String auth, HttpSession hs){
        String rand = (String)hs.getAttribute("rand");
        if(rand.equalsIgnoreCase(auth)){
            String info = userService.selectUserByUsername(user_username, user_userpassword);
            if(info.equals("登录成功")){
                hs.setAttribute("user_username",user_username);
            }
            return info;
        }else{
            return "验证码错误";
        }
    }
}

