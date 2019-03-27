package com.hwua.serviceImpl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hwua.dao.GoodsDao;
import com.hwua.entity.Goods;
import com.hwua.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    GoodsDao goodsDao;
    //查询所有的商品
    @Override
    public List<Goods> selectAllGoods() {
        List<Goods> list = goodsDao.selectAllGoods();
        return list;
    }

    @Override
    public List<Goods> selectAllGoodsForPage(int pageNumber, int pageSize) {
        Page page= PageHelper.startPage(pageNumber,pageSize);
        List<Goods> list = goodsDao.selectAllGoods();
        return list;
    }
}
