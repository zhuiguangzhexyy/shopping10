package com.hwua.dao;

import com.hwua.entity.Goods;

import java.util.List;

public interface GoodsDao {
    //查询所有商品
    public List<Goods> selectAllGoods();
}
