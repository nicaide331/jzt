package com.example.jzt.dao;

import com.example.jzt.model.TestOrder;
import com.example.jzt.model.TestStock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class JdbcStock {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public Long countByIds(List<Long> ids) {

        String sql = "SELECT count(1) as cnt FROM test_stock_ncd ";
        Map<String, Object> result = namedParameterJdbcTemplate.queryForMap(sql, (SqlParameterSource) namedParameterJdbcTemplate);

        return ((Number) result.get("cnt")).longValue();

    }

    public List<TestStock> findByIds(List<Long> ids) {

        Map<String, Object> map = new HashMap<>();
        String sql = "SELECT  ts.ts_id, ts.ts_num FROM test_stock_ncd ts in (:ids) for update";
        map.put("ids", ids);
        return namedParameterJdbcTemplate.query(sql, map, new BeanPropertyRowMapper<>(TestStock.class));
    }

    public void batchSave(List<TestStock> sqlStockList) {

        Date date = new Date();
        String sql = "update test_stock_ncd set ts_num = :tsNum, ts_update_time = nowDate where ts_id = :tsId";

        Map<String, Object>[] maps = new HashMap[sqlStockList.size()];
        Map<String, Object> map = null;
        int i = 0;
        for (TestStock stock : sqlStockList) {
            map = new HashMap<>();
            map.put("tsNum", stock.getTsNum());
            map.put("tsId", stock.getTsId());
            map.put("nowDate", date);
            maps[i] = map;
            i++;
        }
        namedParameterJdbcTemplate.batchUpdate(sql, maps);

    }

    public List<TestStock> findByGoodsId(Long goodsId) {

        String sql = " select * from test_stock_ncd ts where ts.ts_goods_id = :goodsId ";
        HashMap<String, Object> param = new HashMap<>();
        param.put("goodsId", goodsId);
        return namedParameterJdbcTemplate.query(sql, param, new BeanPropertyRowMapper<>(TestStock.class));
    }
}
