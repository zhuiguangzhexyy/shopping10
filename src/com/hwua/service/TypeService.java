package com.hwua.service;

import com.hwua.entity.Type;

import java.util.List;

public interface TypeService {
   //查询所有的商品类型
    public List<Type> selectAllType();
    //查询所有商品的大类型
    public List<Type>selectAllBigType();
    //根据大类型的ID查询所有对应的小类型
    public List<Type> selectAllSmallTypeByBigType(int type);
}
