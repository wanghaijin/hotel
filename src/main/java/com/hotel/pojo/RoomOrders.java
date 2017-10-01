package com.hotel.pojo;

import java.sql.Timestamp;
import java.util.List;

public class RoomOrders {
	//������
	private int roomOrdersId;
	//��ס�����
	private String roomNum;
	private Room room;
	//��ס��Ա
	private List<User> users;
	//��סʱ��
	private Timestamp roomOrdersStartTime;
	//�˷�ʱ��
	private Timestamp roomOrdersEndTime;
//	//���֤����
//	private String userId;
//	private String userName;
	//�����Ƿ����˷�,02-��סδ�˷�,00-��ס���˷�,03-Ԥ��δ��ס
	private String ordersType;
	//������ס����
	private int roomOrdersNum;
	//���䵥��
	private int roomPrice;
	//����Ѻ��
	private int roomOrdersPrice;
	//����ά��ʱ��
	private long ordersHoldTime;
	
	
	@Override
	public String toString() {
		return "RoomOrders [roomOrdersId=" + roomOrdersId + ", roomNum=" + roomNum + ", room=" + room + ", users="
				+ users + ", roomOrdersStartTime=" + roomOrdersStartTime + ", roomOrdersEndTime=" + roomOrdersEndTime
				+ ", ordersType=" + ordersType + ", roomOrdersNum=" + roomOrdersNum + ", roomPrice=" + roomPrice
				+ ", roomOrdersPrice=" + roomOrdersPrice + ", ordersHoldTime=" + ordersHoldTime + "]";
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public long getOrdersHoldTime() {
		return ordersHoldTime;
	}
	public void setOrdersHoldTime() {
//		this.ordersHoldTime = ordersHoldTime;
	this.ordersHoldTime=(this.roomOrdersEndTime.getTime()-this.roomOrdersStartTime.getTime())/(24*3600);
	}
	public int getRoomOrdersId() {
		return roomOrdersId;
	}
	public void setRoomOrdersId(int roomOrdersId) {
		this.roomOrdersId = roomOrdersId;
	}
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	
	public String getOrdersType() {
		return ordersType;
	}
	public void setOrdersType(String ordersType) {
		this.ordersType = ordersType;
	}
	public String getRoomNum() {
		return roomNum;
	}
	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}
	public Timestamp getRoomOrdersStartTime() {
		return roomOrdersStartTime;
	}
	public void setRoomOrdersStartTime(Timestamp roomOrdersStartTime) {
		this.roomOrdersStartTime = roomOrdersStartTime;
	}
	public Timestamp getRoomOrdersEndTime() {
		return roomOrdersEndTime;
	}
	public void setRoomOrdersEndTime(Timestamp roomOrdersEndTime) {
		this.roomOrdersEndTime = roomOrdersEndTime;
	}
	public int getRoomOrdersNum() {
		return roomOrdersNum;
	}
	public void setRoomOrdersNum(int roomOrdersNum) {
		this.roomOrdersNum = roomOrdersNum;
	}
	public int getRoomPrice() {
		return roomPrice;
	}
	public void setRoomPrice(int roomPrice) {
		this.roomPrice = roomPrice;
	}
	public int getRoomOrdersPrice() {
		return roomOrdersPrice;
	}
	public void setRoomOrdersPrice(int roomOrdersPrice) {
		this.roomOrdersPrice = roomOrdersPrice;
	}

	
	

	
}
