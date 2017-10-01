package com.hotel.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.hotel.pojo.RoomOrders;

public interface RoomOrdersService {
	//���ݷ���״̬�����֤�Ų�ѯ��������ҳ
		public PageInfo<RoomOrders> selectRoomOrders(int pageNum,int pageSize,String ordersType,String userId,String roomNum,String startTime,String endTime);
		public List<RoomOrders> selectRoomOrders(String ordersType,String userId,String roomNum,String startTime,String endTime);
//		//����`��������ʱ��β�ѯ����
		//���붩��,�����ض�����
		public int insertRoomOrders(String roomNum,String roomOrdersNum,String roomPrice,String roomOrdersPrice,String ordersType);
		//���¶���
		public boolean updateRoomOrders(String roomOrdersId,String ordersType);
		//ɾ������
		public boolean deleteRoomOrders(int roomOrdersId);
}
