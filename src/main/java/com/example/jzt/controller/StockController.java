package com.example.jzt.controller;


import com.example.jzt.model.TestStock;
import com.example.jzt.serivce.IStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stock")
public class StockController {

    @Autowired
    private IStockService iStockService;

    @GetMapping(value = "/query/{goodsId}")
    public TestStock findByGoodsId(@PathVariable("goodsId") Long goodsId) {
        if (goodsId == null) {
            //异常
        }
        return iStockService.findByGoodsId(goodsId);
    }

}
