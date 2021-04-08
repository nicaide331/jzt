package com.example.jzt.controller;

import com.example.jzt.model.TestOrder;
import com.example.jzt.model.dto.SaveOrderDTO;
import com.example.jzt.serivce.IOrderService;
import com.example.jzt.serivce.IStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private IStockService iStockService;

    @Autowired
    private IOrderService iOrderService;

    @PostMapping("/save")
    private void save(SaveOrderDTO saveOrderDTO) {


    }

    @GetMapping("/query/stock")
    private TestOrder findOrder(@RequestParam("goodsId") Long goodsId){

        return null;
    }


}
