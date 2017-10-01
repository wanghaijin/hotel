package com.hotel.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hotel.pojo.RoomOrders;

public interface RoomOrdersMapper {
	//根据房间状态或身份证号查询订单
	public List<RoomOrders> selectRoomOrders(@Param("roomOrders")RoomOrders roomOrders,@Param("userId")String userId
			,@Param("startTime")String startTime,@Param("endTime")String endTime);
	//插入订单
	public int insertRoomOrders(@Param("roomOrders")RoomOrders roomOrders);
	//更新订单
	public int updateRoomOrders(@Param("roomOrdersId")int roomOrdersId,@Param("ordersType")String ordersType);
	//删除订单
	public int deleteRoomOrders(@Param("roomOrdersId")int roomOrdersId);
}
