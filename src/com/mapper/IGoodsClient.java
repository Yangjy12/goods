package com.mapper;

import com.vo.GoodsClient;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IGoodsClient {
    @Select("SELECT c.cid,c.cname FROM g_c gc,goodsclient c WHERE gc.cid=c.cid AND gc.gid=#{gid}")
    public List<GoodsClient> selectBygid(Integer id);

}
