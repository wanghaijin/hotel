package com.hotel.pojo;

//房间类型
public class RoomSize {
	private int sizeId;
	private String sizeName;
	public int getSizeId() {
		return sizeId;
	}
	public void setSizeId(int sizeId) {
		this.sizeId = sizeId;
	}
	public String getSizeName() {
		return sizeName;
	}
	public void setSizeName(String sizeName) {
		this.sizeName = sizeName;
	}
	@Override
	public String toString() {
		return "RoomSize [sizeId=" + sizeId + ", sizeName=" + sizeName + "]";
	}
	
	
	

}
