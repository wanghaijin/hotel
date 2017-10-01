package com.hotel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.mapper.GoodsMapper;
import com.hotel.pojo.Goods;
import com.hotel.service.GoodsService;
@Service
public class GoodsServiceImpl implements GoodsService {
	
	@Autowired
	private GoodsMapper goodsMapper;
	@Override
	public List<Goods> selectGoods(String goodsName) {
		// TODO Auto-generated method stub
		List<Goods> goods=goodsMapper.selectGoods(goodsName);
		return goods;
	}

	@Override
	public boolean insertGoods(String goodsName) {
		// TODO Auto-generated method stub
		List<Goods> allGoods=goodsMapper.selectGoods(null);
		//判断存储的商品数据库中是否存在
		for(Goods good:allGoods) {
			if (good.getGoodsName().equals(goodsName)) {
				return false;
			}
		}
		//插入数据
		Goods goods=new Goods();
		goods.setGoodsName(goodsName);
		int changeLine=goodsMapper.insertGoods(goods);
		//插入是否成功
		if(changeLine != 0) {
			return true;
		}
		return false;
	}

}
