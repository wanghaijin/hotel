package com.hotel.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hotel.pojo.RoomOrders;

public interface RoomOrdersMapper {
	//���ݷ���״̬�����֤�Ų�ѯ����
	public List<RoomOrders> selectRoomOrders(@Param("roomOrders")RoomOrders roomOrders,@Param("userId")String userId
			,@Param("startTime")String startTime,@Param("endTime")String endTime);
	//���붩��
	public int insertRoomOrders(@Param("roomOrders")RoomOrders roomOrders);
	//���¶���
	public int updateRoomOrders(@Param("roomOrdersId")int roomOrdersId,@Param("ordersType")String ordersType);
	//ɾ������
	public int deleteRoomOrders(@Param("roomOrdersId")int roomOrdersId);
}
