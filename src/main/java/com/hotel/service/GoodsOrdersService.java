package com.hotel.service;



import com.github.pagehelper.PageInfo;
import com.hotel.pojo.GoodsOrders;

public interface GoodsOrdersService {
		//��ѯ��Ʒ����
		public PageInfo<GoodsOrders> selectGoodsOrders(String goodsId,int pageNum,int pageSize);
		//������Ʒ����
		public boolean insertGoodsOrders(GoodsOrders goodsOrders);
		//ɾ����Ʒ����
		public boolean deleteGoodsOrders(String goodsOrdersId);

}
