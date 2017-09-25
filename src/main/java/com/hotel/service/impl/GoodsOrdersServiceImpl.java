package com.hotel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hotel.mapper.GoodsOrdersMapper;
import com.hotel.pojo.GoodsOrders;
import com.hotel.service.GoodsOrdersService;

@Service
public class GoodsOrdersServiceImpl implements GoodsOrdersService {
	@Autowired
	private GoodsOrdersMapper goodsOrdersMapper;

	@Override
	public PageInfo<GoodsOrders> selectGoodsOrders(String goodsId,int pageNum,int pageSize) {
		// TODO Auto-generated method stub
		
		List<GoodsOrders> goodsOrders=goodsOrdersMapper.selectGoodsOrders(goodsId);
		PageHelper.startPage(pageNum,pageSize);
		return new PageInfo<GoodsOrders>(goodsOrders);
//		return goodsOrders;
	}

	@Override
	public boolean insertGoodsOrders(GoodsOrders goodsOrders) {
		// TODO Auto-generated method stub
//		goodsService.insertGoods(goodsName);
		int changeLine=goodsOrdersMapper.insertGoodsOrders(goodsOrders);
		if (changeLine != 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteGoodsOrders(String goodsOrdersId) {
		// TODO Auto-generated method stub
		int changeLine=goodsOrdersMapper.deleteGoodsOrders(goodsOrdersId);
		if (changeLine != 0) {
			return true;
		}
		return false;
	}

}
