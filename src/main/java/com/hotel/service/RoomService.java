package com.hotel.service;

import java.util.List;


import com.hotel.pojo.Room;

public interface RoomService {
	public List<Room> selectRoom(String roomTypeId);
	public Boolean updateRoomByRoomNum(String roomNum,String roomType);
	public boolean insertRoom(String roomNum,String roomSize);
	public boolean deleteRoom(String roomNum);
}
