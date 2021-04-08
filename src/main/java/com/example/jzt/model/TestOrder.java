package com.example.jzt.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class TestOrder {

    private Long toId;

    private Long toGoodsId;

    private Long toName;

    private Integer toNum;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date toCreateTime;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date toUpdateTime;

    private  String toStatus;


    public Long getToId() {
        return toId;
    }

    public void setToId(Long toId) {
        this.toId = toId;
    }

    public Long getToGoodsId() {
        return toGoodsId;
    }

    public void setToGoodsId(Long toGoodsId) {
        this.toGoodsId = toGoodsId;
    }

    public Long getToName() {
        return toName;
    }

    public void setToName(Long toName) {
        this.toName = toName;
    }

    public Integer getToNum() {
        return toNum;
    }

    public void setToNum(Integer toNum) {
        this.toNum = toNum;
    }

    public Date getToCreateTime() {
        return toCreateTime;
    }

    public void setToCreateTime(Date toCreateTime) {
        this.toCreateTime = toCreateTime;
    }

    public Date getToUpdateTime() {
        return toUpdateTime;
    }

    public void setToUpdateTime(Date toUpdateTime) {
        this.toUpdateTime = toUpdateTime;
    }

    public String getToStatus() {
        return toStatus;
    }

    public void setToStatus(String toStatus) {
        this.toStatus = toStatus;
    }
}
