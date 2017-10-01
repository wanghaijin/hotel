package com.hotel.service;


import com.github.pagehelper.PageInfo;
import com.hotel.pojo.GoodsOrders;

public interface GoodsOrdersService {
		//查询商品订单
		public PageInfo<GoodsOrders> selectGoodsOrders(int pageNum,int pageSize,String goodsId,String dateStart,String dateEnd);
		//生成商品订单
		public boolean insertGoodsOrders(GoodsOrders goodsOrders);
		//删除商品订单
		public boolean deleteGoodsOrders(String goodsOrdersId);

}
