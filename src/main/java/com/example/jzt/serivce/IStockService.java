package com.example.jzt.serivce;

import com.example.jzt.model.TestStock;

public interface IStockService {
    TestStock findByGoodsId(Long goodsId);
}
