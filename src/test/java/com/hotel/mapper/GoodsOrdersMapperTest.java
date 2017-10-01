package com.hotel.mapper;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hotel.pojo.GoodsOrders;

public class GoodsOrdersMapperTest {
	private GoodsOrdersMapper goodsOrdersMapper;

	@Before
	public void setUp() throws Exception {
		ApplicationContext context=new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
		goodsOrdersMapper=context.getBean(GoodsOrdersMapper.class);
	}

	@Test
	public void testSelectGoodsOrders() {
//		fail("Not yet implemented");
		List<GoodsOrders> goodsOrders=goodsOrdersMapper.selectGoodsOrders(null,null,null);
		System.out.println(goodsOrders);
	}

	@Test
	public void testInsertGoodsOrders() {
		fail("Not yet implemented");
//		GoodsOrders goodsOrders=new GoodsOrders();
//		goodsOrders.setGoodsOrdersAmount(10);
//		for(int i=1;i<9;i++) {
//			goodsOrders.setGoodsId(i);
//			goodsOrdersMapper.insertGoodsOrders(goodsOrders);
//		}
	}

	@Test
	public void testDeleteGoodsOrders() {
		fail("Not yet implemented");
	}

}
