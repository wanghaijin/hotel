package com.hotel.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hotel.pojo.Room;
import com.hotel.pojo.RoomSize;
import com.hotel.service.RoomService;
import com.hotel.service.RoomSizeService;

@Controller
public class RoomController {
	@Autowired
	private RoomService roomService;
	@Autowired
	private RoomSizeService roomSizeService;
	
	@RequestMapping(value="room")
	public String room(Model model) {
		return "room/room";
	}
	
	//响应roomType1,roomType2....页面,管理房间的使用
	@RequestMapping(value="roomType{page}")
	public String roomType(@PathVariable String page,@RequestParam(value="roomNum",defaultValue="0")String roomNum,
		@RequestParam(value="roomType",defaultValue="0")String roomType,Model model) {
		if (!(roomNum.equals("0")) && !(roomType.equals("0"))) {
			roomService.updateRoomByRoomNum(roomNum, roomType);
		}
		List<Room> rooms=roomService.selectRoom(page);
		model.addAttribute("rooms", rooms);
		String string="room/roomType"+page;
		return string;
	}

	//管理房间的新增和减少
	@RequestMapping(value="changeRooms{isInsert}")
	public String changRoom(@PathVariable String isInsert,@RequestParam(value="roomNum",defaultValue="0")String roomNum,@RequestParam(value="roomSize",defaultValue="0")String roomSize,Model model) {
		if (isInsert.equals("Insert")) {
			//判断是否插入成功
			boolean isSuccess=false;
			String string=null;
			if(!roomNum.equals("0")&&!roomSize.equals("0")) {
				if (roomNum.length()==3) {
					isSuccess=roomService.insertRoom(roomNum, roomSize);
				}
				if (isSuccess) {
					string="插入成功,可以继续插入";
				}else {
					string="插入失败,可能是已有此房间号或者是格式不对,请重新输入一个三位数的数字编号";
				}
			}
			model.addAttribute("string", string);
			List<RoomSize> roomSizes=roomSizeService.selectRoomSize();
			model.addAttribute("roomSizes", roomSizes);
		}
		//返回页面
		String string="room/changeRooms"+isInsert;
		return string;
	}
}
