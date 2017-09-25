package com.hotel.mapper;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hotel.pojo.Goods;

public class GoodsMapperTest {
	private GoodsMapper goodsMapper;

	@Before
	public void setUp() throws Exception {
		ApplicationContext context=new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
		goodsMapper=context.getBean(GoodsMapper.class);
	}

	@Test
	public void testSelectGoods() {
//		fail("Not yet implemented");
		List<Goods> goods=goodsMapper.selectGoods("¿µÊ¦¸µ1");
		for(Goods good:goods) {
			System.out.println(good);
		}
	}

	@Test
	public void testInsertGoods() {
		fail("Not yet implemented");
//		Goods goods=new Goods();
//		for(int i=1;i<=9;i++) {
//			goods.setGoodsName("¿µÊ¦¸µ"+i);
//			goodsMapper.insertGoods(goods);
//		}
	}

}
