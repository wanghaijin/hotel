package com.hotel.mapper;


import org.apache.ibatis.annotations.Param;

import com.hotel.pojo.User;

public interface UserMapper {
	//���ݶ�����ѡ������
//	public List<User> selectUser(@Param("ordersType")String ordersType,@Param("userId")String userId
//			,@Param("roomNum")String roomNum,@Param("startTime")String startTime,@Param("endTime")String endTime);
	//��������
	public int insertUser(@Param("user")User user);

}
