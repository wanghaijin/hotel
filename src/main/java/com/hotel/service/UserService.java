package com.hotel.service;

import com.hotel.pojo.User;

public interface UserService {
	//根据订单号选择人物
//		public List<User> selectUser(String ordersType,String userId,String roomNum,String startTime,String endTime);
		//插入人物
		public boolean insertUser(User user);
}
