package com.example.jzt.controller;


import com.example.jzt.model.dto.SaveOrderDTO;
import com.example.jzt.serivce.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private IOrderService iOrderService;

    @PostMapping("/save")
    private void save(SaveOrderDTO saveOrderDTO) {

        iOrderService.save(saveOrderDTO);

    }

}
