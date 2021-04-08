package com.example.jzt.model.dto;

import com.example.jzt.model.TestOrder;
import com.example.jzt.model.TestStock;

import java.util.List;

public class SaveOrderDTO {

    private List<TestOrder> order;

    private List<TestStock> stock;

    public List<TestOrder> getOrder() {
        return order;
    }

    public void setOrder(List<TestOrder> order) {
        this.order = order;
    }

    public List<TestStock> getStock() {
        return stock;
    }

    public void setStock(List<TestStock> stock) {
        this.stock = stock;
    }
}
