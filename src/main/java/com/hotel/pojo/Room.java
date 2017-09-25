package com.hotel.pojo;


public class Room {

	//房间号
	private String roomNum;
	//房间状态
	//1-空闲\2-入住\3-预定\4-清洁
	private int roomType;

	//房型
	private RoomSize roomSize;

	public String getRoomNum() {
		return roomNum;
	}
	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}

	public int getRoomType() {
		return roomType;
	}
	public void setRoomType(int roomType) {
		this.roomType = roomType;
	}
	public RoomSize getRoomSize() {
		return roomSize;
	}
	public void setRoomSize(RoomSize roomSize) {
		this.roomSize = roomSize;
	}
	@Override
	public String toString() {
		return "Room [roomNum=" + roomNum + ", roomType=" + roomType + ", roomSize=" + roomSize + "]";
	}

	
	
	
}
