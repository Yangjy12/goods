package com.vo;

import java.util.List;

public class GoodsClient {
    private int cid;
    private String cname;
    private List<GoodsStore> goods;
    public GoodsClient() {
    }
    public int getCid() {
        return cid;
    }
    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public List<GoodsStore> getGoods() {
        return goods;
    }

    public void setGoods(List<GoodsStore> goods) {
        this.goods = goods;
    }

    @Override
    public String toString() {
        return "GoodsClient{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                '}';
    }
}
