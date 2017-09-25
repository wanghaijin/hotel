package com.hotel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.mapper.RoomMapper;
import com.hotel.pojo.Room;
import com.hotel.pojo.RoomSize;
import com.hotel.service.RoomService;

@Service
public class RoomServiceImpl implements RoomService{
	@Autowired
	private	RoomMapper roomMapper;

	@Override
	public List<Room> selectRoom(String roomTypeId) {
		// TODO Auto-generated method stub
		int typeId=Integer.valueOf(roomTypeId);
		List<Room> rooms=roomMapper.selectRoom(typeId);
//		System.out.println(roomType2);
		return rooms;
	}

	@Override
	public Boolean updateRoomByRoomNum(String roomNum,String roomType) {
		// TODO Auto-generated method stub
		int typeId=Integer.valueOf(roomType.trim());
		int changline=roomMapper.updateRoomByRoomNum(roomNum,typeId);
		if (changline!=0) {
				return true;
		}
		return false;
	}


	@Override
	public boolean deleteRoom(String roomNum) {
		// TODO Auto-generated method stub
		int changline=roomMapper.deleteRoom(roomNum);
		if (changline!=0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean insertRoom(String roomNum, String roomSize) {
		// TODO Auto-generated method stub
		Room room=new Room();
		RoomSize roomSize2=new RoomSize();
		roomSize2.setSizeId(Integer.valueOf(roomSize.trim()));
		room.setRoomNum(roomNum);
		room.setRoomType(1);
		room.setRoomSize(roomSize2);
		int changline=roomMapper.insertRoom(room);
		if (changline!=0) {
			return true;
		}
		return false;
	}




}
