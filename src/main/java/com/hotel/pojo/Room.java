package com.hotel.pojo;


public class Room {

	//�����
	private String roomNum;
	//����״̬
	//1-����\2-��ס\3-Ԥ��\4-���
	private int roomType;
	//���䶩����Ϣ

	//����
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

	
	
	
	
}
