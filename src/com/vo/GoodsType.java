package com.vo;

import java.util.List;

public class GoodsType {
    private int tid;
    private String tname;
    private List<GoodsStore> goods;

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public List<GoodsStore> getGoods() {
        return goods;
    }

    public void setGoods(List<GoodsStore> goods) {
        this.goods = goods;
    }

    public GoodsType() {
    }
}
