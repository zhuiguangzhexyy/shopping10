package com.hwua.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hwua.entity.Type;
import com.hwua.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/type")
public class TypeController {
    @Autowired
    TypeService typeService;
    //查询所有的商品类型
    public String selectAllType(){
        List<Type> list = typeService.selectAllType();
        return "";
    }
    //查询所有的商品大类型
    @RequestMapping(value = "/selectAllBigType",produces ="text/html;charset=UTF-8" )
    @ResponseBody
    public String selectAllBigType(){
        List<Type> list = typeService.selectAllBigType();
        String str = JSON.toJSONString(list);
        return str;
    }




//查询所有的大类型并且包含对应所有小类型
    @RequestMapping(value = "/selectAllTypeForOrder",produces ="text/html;charset=UTF-8" )
    @ResponseBody
    public String selectAllTypeForOrder(){
        //创建集合用来存储所有的类型
        List<List<Type>> list=new ArrayList<List<Type>>();
        //查询所有的大类型
        List<Type> big = typeService.selectAllBigType();
        //循环遍历大类型集合
        for(int i=0;i<big.size();i++){
            //通过大类型id来查询所有对应的小类型(包含了大类型)
            List<Type> small = typeService.selectAllSmallTypeByBigType(big.get(i).getType_id());
            //把每组数据放入集合中
            list.add(small);
        }
        String str = JSONObject.toJSONString(list);
        return str;
    }
}
