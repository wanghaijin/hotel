package com.hotel.mapper;


import org.apache.ibatis.annotations.Param;

import com.hotel.pojo.User;

public interface UserMapper {
	//根据订单号选择人物
//	public List<User> selectUser(@Param("ordersType")String ordersType,@Param("userId")String userId
//			,@Param("roomNum")String roomNum,@Param("startTime")String startTime,@Param("endTime")String endTime);
	//插入人物
	public int insertUser(@Param("user")User user);

}
