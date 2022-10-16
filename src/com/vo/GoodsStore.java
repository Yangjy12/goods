package com.vo;
import java.util.List;
public class GoodsStore {
    private int gid,gnum,tid;
    private String gname,tname,proname;
    private float gprize;
    private List<GoodsClient> goodsClients;
    private GoodsType goodsType;
    public GoodsStore() {
    }
    public int getGid() {
        return gid;
    }
    public void setGid(int gid) {
        this.gid = gid;
    }
    public int getGnum() {
        return gnum;
    }
    public void setGnum(int gnum) {
        this.gnum = gnum;
    }
    public int getTid() {
        return tid;
    }
    public void setTid(int tid) {
        this.tid = tid;
    }
    public String getGname() {
        return gname;
    }
    public void setGname(String gname) {
        this.gname = gname;
    }
    public String getTname() {
        return tname;
    }
    public void setTname(String tname) {
        this.tname = tname;
    }
    public String getProname() {
        return proname;
    }
    public void setProname(String proname) {
        this.proname = proname;
    }
    public float getGprize() {
        return gprize;
    }
    public void setGprize(float gprize) {
        this.gprize = gprize;
    }
    public List<GoodsClient> getGoodsClients() {
        return goodsClients;
    }
    public void setGoodsClients(List<GoodsClient> goodsClients) {
        this.goodsClients = goodsClients;
    }
    public GoodsType getGoodsType() {
        return goodsType;
    }
    public void setGoodsType(GoodsType goodsType) {
        this.goodsType = goodsType;
    }
    @Override
    public String toString() {
        return "GoodsStore{" +
                "gid=" + gid +
                ", gnum=" + gnum +
                ", tid=" + tid +
                ", gname='" + gname + '\'' +
                ", tname='" + tname + '\'' +
                ", proname='" + proname + '\'' +
                ", gprize=" + gprize +
                '}';
    }
}
