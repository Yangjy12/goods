package com.mapper;

import com.vo.GoodsClient;
import com.vo.GoodsStore;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IGoods {
    @Insert("insert into goodsstore values(default,#{gname},#{gnum},#{gprize},#{tname},#{tid},#{proname})")
    public int InsertGoods(GoodsStore goods);
    @Select("SELECT gid,gname,gnum,gprize,proname,tname FROM goodsstore WHERE tid=#{tid}")
    public List<GoodsStore> selectBytid(Integer id);
    @Select("SELECT DISTINCT g.gid,g.gname,g.gnum,g.gprize,g.proname,g.tname FROM goodsstore g,g_c gc WHERE gc.gid=g.gid")
    @Results({
            @Result(column = "gid",property = "gid"),
            @Result(column = "gname",property = "gname"),
            @Result(column = "gnum",property = "gnum"),
            @Result(
                    property = "goodsClients",   // 被包含对象的变量名
                    javaType = List.class,  // 被包含对象的实际数据类型
                    column = "gid",
                    many = @Many(select = "com.mapper.IGoodsClient.selectBygid")
            )
    })
    public List<GoodsStore> selectGPAll();
}
