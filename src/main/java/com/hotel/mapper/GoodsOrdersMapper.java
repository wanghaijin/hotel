package com.hotel.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hotel.pojo.GoodsOrders;

public interface GoodsOrdersMapper {
	//查询商品订单
	public List<GoodsOrders> selectGoodsOrders(@Param("goodsId")String goodsId);
	//生成商品订单
	public int insertGoodsOrders(@Param("goodsOrders")GoodsOrders goodsOrders);
	//删除商品订单
	public int deleteGoodsOrders(@Param("goodsOrdersId")String goodsOrdersId);
}
