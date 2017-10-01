package com.hotel.pojo;

import java.sql.Timestamp;
import java.util.List;

public class RoomOrders {
	//订单号
	private int roomOrdersId;
	//入住房间号
	private String roomNum;
	private Room room;
	//入住人员
	private List<User> users;
	//入住时间
	private Timestamp roomOrdersStartTime;
	//退房时间
	private Timestamp roomOrdersEndTime;
//	//身份证号码
//	private String userId;
//	private String userName;
	//房间是否已退房,02-入住未退房,00-入住已退房,03-预定未入住
	private String ordersType;
	//房间入住人数
	private int roomOrdersNum;
	//房间单价
	private int roomPrice;
	//房间押金
	private int roomOrdersPrice;
	//订单维持时间
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
