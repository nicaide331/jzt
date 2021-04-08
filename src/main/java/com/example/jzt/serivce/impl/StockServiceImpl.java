package com.example.jzt.serivce.impl;

import com.example.jzt.dao.JdbcStock;
import com.example.jzt.model.TestStock;
import com.example.jzt.serivce.IStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockServiceImpl implements IStockService {

    @Autowired
    private JdbcStock jdbcStock;

    @Override
    public TestStock findByGoodsId(Long goodsId) {
        List<TestStock> list = jdbcStock.findByGoodsId(goodsId);
        return list.size() > 0 ? list.get(0) : null;
    }
}
