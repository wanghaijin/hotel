package com.hotel.service;

import com.hotel.pojo.User;

public interface UserService {
	//���ݶ�����ѡ������
//		public List<User> selectUser(String ordersType,String userId,String roomNum,String startTime,String endTime);
		//��������
		public boolean insertUser(User user);
}
