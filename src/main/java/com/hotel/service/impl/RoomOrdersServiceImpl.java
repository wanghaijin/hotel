package com.hotel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hotel.mapper.RoomOrdersMapper;
import com.hotel.pojo.RoomOrders;
import com.hotel.service.RoomOrdersService;

@Service
public class RoomOrdersServiceImpl implements RoomOrdersService {
	@Autowired
	private RoomOrdersMapper roomOrdersMapper;
	

	@Override
	public int insertRoomOrders(String roomNum,String roomOrdersNum,String roomPrice,String roomOrdersPrice,String ordersType){
		// TODO Auto-generated method stub
		//将订单插入数据库
		RoomOrders roomOrders=new RoomOrders();
		//设置房间号
		roomOrders.setRoomNum(roomNum);
		//设置入住人数
		roomOrders.setRoomOrdersNum(Integer.valueOf(roomOrdersNum.trim()));
		//设置房间单价
		roomOrders.setRoomPrice(Integer.valueOf(roomPrice.trim()));
		//设置押金
		roomOrders.setRoomOrdersPrice(Integer.valueOf(roomOrdersPrice.trim()));
		roomOrders.setOrdersType(ordersType);
	    roomOrdersMapper.insertRoomOrders(roomOrders);
	   
		return roomOrders.getRoomOrdersId();
	}

	@Override
	public boolean updateRoomOrders(String roomOrdersId,String ordersType) {
		// TODO Auto-generated method stub
		int num_roomOrdersId=Integer.valueOf(roomOrdersId);
		int changeLine=roomOrdersMapper.updateRoomOrders(num_roomOrdersId,ordersType);
		if (changeLine != 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteRoomOrders(int roomOrdersId) {
		// TODO Auto-generated method stub
		int changeLine=roomOrdersMapper.deleteRoomOrders(roomOrdersId);
		if (changeLine != 0) {
			return true;
		}
		return false;
	}

	@Override
	public PageInfo<RoomOrders> selectRoomOrders(int pageNum,int pageSize,String ordersType,String userId,String roomNum,String startTime, String endTime) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum,pageSize);
		RoomOrders roomOrder=new RoomOrders();
		roomOrder.setOrdersType(ordersType);
//		roomOrder.setUserId(userId);
		roomOrder.setRoomNum(roomNum);
		if ((!startTime.equals(null))&&(!startTime.equals(""))) {
			startTime+=" 00:00:00";
		}
		if ((!endTime.equals(null))&&(!endTime.equals(""))) {
			endTime+=" 23:59:59";
		}
		List<RoomOrders> roomOrders=roomOrdersMapper.selectRoomOrders(roomOrder,userId,startTime,endTime);
		return new PageInfo<RoomOrders>(roomOrders);
	}

	@Override
	public List<RoomOrders> selectRoomOrders(String ordersType, String userId, String roomNum, String startTime,
			String endTime) {
		// TODO Auto-generated method stub
		RoomOrders roomOrder=new RoomOrders();
		roomOrder.setOrdersType(ordersType);
//		roomOrder.setUserId(userId);
		roomOrder.setRoomNum(roomNum);
		if ((!startTime.equals(null))&&(!startTime.equals(""))) {
			startTime+=" 00:00:00";
		}
		if ((!endTime.equals(null))&&(!endTime.equals(""))) {
			endTime+=" 23:59:59";
		}
		List<RoomOrders> roomOrders=roomOrdersMapper.selectRoomOrders(roomOrder,userId,startTime,endTime);
		return roomOrders;
	}

}
