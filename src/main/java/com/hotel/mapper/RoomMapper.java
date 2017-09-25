package com.hotel.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hotel.pojo.Room;

//房间管理
public interface RoomMapper {
	
	public List<Room> selectRoom(@Param("type")int roomType);
	public int updateRoomByRoomNum(@Param("number")String roomNum,@Param("type")int roomType);
	public int insertRoom(@Param("room")Room room);
	public int deleteRoom(@Param("number")String roomNum);

}
