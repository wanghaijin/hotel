package com.hotel.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.hotel.pojo.RoomOrders;

public interface RoomOrdersService {
	//根据房间状态或身份证号查询订单并分页
		public PageInfo<RoomOrders> selectRoomOrders(int pageNum,int pageSize,String ordersType,String userId,String roomNum,String startTime,String endTime);
		public List<RoomOrders> selectRoomOrders(String ordersType,String userId,String roomNum,String startTime,String endTime);
//		//根据`订单创建时间段查询订单
		//插入订单,并返回订单号
		public int insertRoomOrders(String roomNum,String roomOrdersNum,String roomPrice,String roomOrdersPrice,String ordersType);
		//更新订单
		public boolean updateRoomOrders(String roomOrdersId,String ordersType);
		//删除订单
		public boolean deleteRoomOrders(int roomOrdersId);
}
