package com.hotel.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hotel.pojo.Goods;
//ÉÌÆ·²Ù×÷
public interface GoodsMapper {
	
	public List<Goods> selectGoods(@Param("goodsName")String goodsName);
	public int insertGoods(@Param("goods")Goods goods);

}
