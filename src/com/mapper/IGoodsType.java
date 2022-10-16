package com.mapper;

import com.vo.GoodsType;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IGoodsType {
    @Results(value = {
            @Result(id = true,column = "tid",property = "tid"),
            @Result(column = "tname",property = "tname"),
            @Result(
                    property = "goods",//被包含对象的变量名
                    javaType = List.class,//被包含对象的实际数据类型
                    column = "tid",//tid作为关联条件
                    many = @Many(select = "com.mapper.IGoods.selectBytid")
            )

    })
    @Select("select * from goodstype")
    public List<GoodsType> SelectTAll();
}
