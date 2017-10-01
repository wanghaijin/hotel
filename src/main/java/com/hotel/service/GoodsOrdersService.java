package com.hotel.service;


import com.github.pagehelper.PageInfo;
import com.hotel.pojo.GoodsOrders;

public interface GoodsOrdersService {
		//��ѯ��Ʒ����
		public PageInfo<GoodsOrders> selectGoodsOrders(int pageNum,int pageSize,String goodsId,String dateStart,String dateEnd);
		//������Ʒ����
		public boolean insertGoodsOrders(GoodsOrders goodsOrders);
		//ɾ����Ʒ����
		public boolean deleteGoodsOrders(String goodsOrdersId);

}
