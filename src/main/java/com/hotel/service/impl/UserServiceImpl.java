package com.hotel.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.mapper.UserMapper;
import com.hotel.pojo.User;
import com.hotel.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
//	@Override
//	public List<User> selectUser(String ordersType,String userId,String roomNum,String startTime,String endTime) {
//		// TODO Auto-generated method stub
//		if ((!startTime.equals(null))&&(!startTime.equals(""))) {
//			startTime+=" 00:00:00";
//		}
//		if ((!endTime.equals(null))&&(!endTime.equals(""))) {
//			endTime+=" 23:59:59";
//		}
//		List<User> users=userMapper.selectUser(ordersType,userId.trim(),roomNum,startTime,endTime);
//		return users;
//	}

	@Override
	public boolean insertUser(User user) {
		// TODO Auto-generated method stub
		int chageLine=userMapper.insertUser(user);
		if (chageLine != 0) {
			return true;
		}
		return false;
	}

}
