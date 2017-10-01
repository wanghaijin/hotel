package com.hotel.pojo;

//客人信息表格
public class User {

	//身份证
	private String userId;
	//名字
	private String userName;
	//所属订单
	private int roomOrdersId;
	private RoomOrders roomOrders;
	//电话
	private String userTel;
	//民族
	private String userNation;
	
	
	public RoomOrders getRoomOrders() {
		return roomOrders;
	}
	public void setRoomOrders(RoomOrders roomOrders) {
		this.roomOrders = roomOrders;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getRoomOrdersId() {
		return roomOrdersId;
	}
	public void setRoomOrdersId(int roomOrdersId) {
		this.roomOrdersId = roomOrdersId;
	}
	public String getUserTel() {
		return userTel;
	}
	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}
	public String getUserNation() {
		return userNation;
	}
	public void setUserNation(String userNation) {
		this.userNation = userNation;
	}

}
