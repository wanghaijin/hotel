package com.hotel.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hotel.pojo.GoodsOrders;

public interface GoodsOrdersMapper {
	//��ѯ��Ʒ����
	public List<GoodsOrders> selectGoodsOrders(@Param("goodsId")String goodsId);
	//������Ʒ����
	public int insertGoodsOrders(@Param("goodsOrders")GoodsOrders goodsOrders);
	//ɾ����Ʒ����
	public int deleteGoodsOrders(@Param("goodsOrdersId")String goodsOrdersId);
}
