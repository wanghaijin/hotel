package com.hotel.pojo;

//������Ϣ���
public class User {

	//���֤
	private String userId;
	//����
	private String userName;
	//��������
	private int roomOrdersId;
	private RoomOrders roomOrders;
	//�绰
	private String userTel;
	//����
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
