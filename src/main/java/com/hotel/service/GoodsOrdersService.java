package com.hotel.service;



import com.github.pagehelper.PageInfo;
import com.hotel.pojo.GoodsOrders;

public interface GoodsOrdersService {
		//查询商品订单
		public PageInfo<GoodsOrders> selectGoodsOrders(String goodsId,int pageNum,int pageSize);
		//生成商品订单
		public boolean insertGoodsOrders(GoodsOrders goodsOrders);
		//删除商品订单
		public boolean deleteGoodsOrders(String goodsOrdersId);

}
