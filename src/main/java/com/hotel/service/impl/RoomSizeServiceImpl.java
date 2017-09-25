package com.hotel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.mapper.RoomSizeMapper;
import com.hotel.pojo.RoomSize;
import com.hotel.service.RoomSizeService;

@Service
public class RoomSizeServiceImpl implements RoomSizeService {
	@Autowired
	private RoomSizeMapper roomSizeMapper;

	@Override
	public List<RoomSize> selectRoomSize() {
		// TODO Auto-generated method stub
		List<RoomSize> sizes=roomSizeMapper.selectRoomSize();
		return sizes;
	}


}
