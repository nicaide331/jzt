package com.example.jzt.serivce.impl;

import com.example.jzt.dao.JdbcOrder;
import com.example.jzt.dao.JdbcStock;
import com.example.jzt.model.TestOrder;
import com.example.jzt.model.TestStock;
import com.example.jzt.model.dto.SaveOrderDTO;
import com.example.jzt.serivce.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private JdbcOrder jdbcOrder;

    @Autowired
    private JdbcStock jdbcStock;

    @Transactional
    @Override
    public void save(SaveOrderDTO saveOrderDTO) {

        saveOrder(saveOrderDTO.getOrder());
        saveStock(saveOrderDTO.getStock());

    }

    private void saveStock(List<TestStock> stockList) {
        List<Long> ids = new ArrayList<>(stockList.size());
        for (TestStock stock: stockList) {
            ids.add(stock.getTsId());
        }

        if (jdbcStock.countByIds(ids) < ids.size()) {
//            throw new Exception("商品不存在!");
        }
        List<TestStock> sqlStockList = jdbcStock.findByIds(ids);

        for (TestStock stock: stockList) {
            for (TestStock sqlStock : sqlStockList) {
                if (stock.getTsId().equals(stock.getTsId())) {
                    if (stock.getTsNum() > sqlStock.getTsNum()){
//                        throw new Exception("库存数量异常!");
                    }
                    sqlStock.setTsNum(sqlStock.getTsNum() - stock.getTsNum());
                }
            }
        }
        jdbcStock.batchSave(sqlStockList);
    }

    private void saveOrder(List<TestOrder> orderList) {
        List<Long> ids = new ArrayList<>(orderList.size());
        List<TestOrder> updateOrder = jdbcOrder.findByIds(ids);
        List<Long> updateIds = new ArrayList<>(updateOrder.size());
        List<TestOrder> insertOrder = new ArrayList<>(ids.size() - updateOrder.size());



        for (TestOrder order: orderList) {
            for (TestOrder update : updateOrder) {
                if (update.getToId().equals(order.getToId())) {
                    update.setToNum(update.getToNum() + order.getToNum());
                    updateIds.add(update.getToId());
                }
            }
            ids.removeAll(updateIds);
            for (Long id: ids) {
                if (id.equals(order.getToId())) {
                    insertOrder.add(order);
                }
            }
        }

        jdbcOrder.batchUpdate(updateOrder);
        jdbcOrder.batchInsert(insertOrder);
    }

}
