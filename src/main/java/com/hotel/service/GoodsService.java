package com.hotel.service;

import java.util.List;


import com.hotel.pojo.Goods;

public interface GoodsService {
	
	public List<Goods> selectGoods(String goodsName);
	public boolean insertGoods(String goodsName);
//	public boolean updateGoods(String goodsId,String goodsAmount,String goodsRemain);
//	public boolean deleteGoods(String goodsId);

}
