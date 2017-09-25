package com.hotel.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hotel.mapper.GoodsMapper;

public class GoodsOrdersServiceTest {
	private GoodsOrdersService goodsOrdersService;

	@Before
	public void setUp() throws Exception {
		ApplicationContext context=new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
		goodsOrdersService=context.getBean(GoodsOrdersService.class);
	}

	@Test
	public void testSelectGoodsOrders() {
//		fail("Not yet implemented");
		System.out.println(goodsOrdersService.selectGoodsOrders(null, 1, 10));
		
	}

	@Test
	public void testInsertGoodsOrders() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteGoodsOrders() {
		fail("Not yet implemented");
	}

}
