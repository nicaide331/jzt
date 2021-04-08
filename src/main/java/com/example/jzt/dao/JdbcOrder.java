package com.example.jzt.dao;

import com.example.jzt.model.TestOrder;
import com.example.jzt.model.TestStock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class JdbcOrder {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void save(List<TestOrder> order) {
    }

    public List<TestOrder> findByIds(List<Long> ids) {
        HashMap<String, Object> param = new HashMap<>();
        String sql = "select to_id, to_num from test_order_ncd  where to_id in (:ids) ";
        param.put("ids", ids);
        return namedParameterJdbcTemplate.query(sql, param, new BeanPropertyRowMapper<>(TestOrder.class));
    }

    public void batchUpdate(List<TestOrder> updateOrder) {

        Date date = new Date();
        String sql = "update test_order_ncd set to_num = :toNum, to_update_time = nowDate where to_id = :toId";

        Map<String, Object>[] maps = new HashMap[updateOrder.size()];
        Map<String, Object> map = null;
        int i = 0;
        for (TestOrder order : updateOrder) {
            map = new HashMap<>();
            map.put("toNum", order.getToNum());
            map.put("toId", order.getToId());
            map.put("nowDate", date);
            maps[i] = map;
            i++;
        }
        namedParameterJdbcTemplate.batchUpdate(sql, maps);

    }

    public void batchInsert(List<TestOrder> insertOrder) {

        Date date = new Date();
        String sql = " insert into test_order_ncd (to_id, to_goods_id, to_name, to_num, to_create_time, to_update_) VALUES " +
                " (:toId, :toGoodsId, :toName, :toNum, :nowDate, :nowDate) ";

        Map<String, Object>[] maps = new HashMap[insertOrder.size()];
        Map<String, Object> map = null;
        int i = 0;
        for (TestOrder order : insertOrder) {
            map = new HashMap<>();
            map.put("toId", order.getToId());
            map.put("toGoodsId", order.getToGoodsId());
            map.put("toName", order.getToName());
            map.put("toNum", order.getToNum());
            map.put("nowDate", date);
            maps[i] = map;
            i++;
        }
    }
}
