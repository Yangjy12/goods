package com.test;

import com.mapper.IGoods;
import com.mapper.IGoodsClient;
import com.mapper.IGoodsType;
import com.vo.GoodsClient;
import com.vo.GoodsStore;
import com.vo.GoodsType;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class GTest {
        private SqlSession session=null;
        private IGoods IGoodsDao;
        private IGoodsType IGoodsTypeDao;
        @Before
        public void init(){
            InputStream is;
            try {
                is = Resources.getResourceAsStream("mybatis_config.xml");
                //2.使用is输入流 创建SessionFactory
                SqlSessionFactory build = new SqlSessionFactoryBuilder().build(is);
                //3.创建数据库链接
                session = build.openSession(true);
                //批量处理
                //session=build.openSession(ExecutorType.BATCH);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }//获取文件
        }
        @After
        public void destory(){
            if(session!=null){
                session.close();
            }
        }
        @Test
        public void InsertGoods(){
            if (session!=null){
                IGoodsDao = session.getMapper(IGoods.class);
                GoodsStore goods=new GoodsStore();
                goods.setGname("水柚饮品");
                goods.setGnum(18);
                goods.setGprize(6);
                goods.setTname("饮品");
                goods.setTid(2);
                goods.setProname("3号饮品商");
                int i = IGoodsDao.InsertGoods(goods);
                session.commit();
                if (i>0){
                    System.out.println("向GoodsStore表中添加数据成功！");
                }
            }
        }
        @Test
        public void SelectTAll(){
                if (session!=null){
                IGoodsTypeDao=session.getMapper(IGoodsType.class);
                List<GoodsType> goodsTypes = IGoodsTypeDao.SelectTAll();
                for (GoodsType type : goodsTypes) {
                    System.out.println("商品类型id："+type.getTid() + ","+"商品类型：" +type.getTname());
                    List<GoodsStore> goods = type.getGoods();
                    for (GoodsStore cours : goods) {
                        System.out.println("\t" + cours);
                    }
                }
            }
        }
        @Test
        public void SelectGPAll(){
            if (session!=null){
                IGoodsDao=session.getMapper(IGoods.class);
                List<GoodsStore> goodsStores = IGoodsDao.selectGPAll();
                for (GoodsStore goods : goodsStores) {
                    System.out.println("商品信息：id："+goods.getGid() + ",名称:" + goods.getGname() + ",数量:" + goods.getGnum()+ ",价格:" + goods.getGprize());
                    List<GoodsClient> goodsClients = goods.getGoodsClients();
                    for (GoodsClient goodsClient : goodsClients) {
                        System.out.println("\t" + goodsClient);
                    }
                }
            }
        }
    }
