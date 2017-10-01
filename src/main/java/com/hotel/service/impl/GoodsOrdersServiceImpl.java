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
	public boolean insertGoodsOrders(GoodsOrders goodsOrders) {
		// TODO Auto-generated method stub
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

	@Override
	public PageInfo<GoodsOrders> selectGoodsOrders(int pageNum,int pageSize,String goodsId, String dateStart, String dateEnd) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum,pageSize);
//		if (!goodsName.trim().equals(null)) {
//			goodsName="%"+goodsName.trim()+"%";
//		}
		if ((!dateStart.equals(null))&&(!dateStart.equals(""))) {
			dateStart+=" 00:00:00";
		}
		if ((!dateEnd.equals(null))&&(!dateEnd.equals(""))) {
			dateEnd+=" 23:59:59";
		}
		List<GoodsOrders> goodsOrders=goodsOrdersMapper.selectGoodsOrders(goodsId.trim(), dateStart, dateEnd);
		
		return new PageInfo<GoodsOrders>(goodsOrders);
	}

}
