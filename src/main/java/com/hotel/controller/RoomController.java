package com.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.hotel.pojo.Room;
import com.hotel.pojo.RoomOrders;
import com.hotel.pojo.RoomSize;
import com.hotel.pojo.User;
import com.hotel.service.RoomOrdersService;
import com.hotel.service.RoomService;
import com.hotel.service.RoomSizeService;
import com.hotel.service.UserService;

@Controller
public class RoomController {
	@Autowired
	private RoomService roomService;
	@Autowired
	private RoomSizeService roomSizeService;
	@Autowired
	private RoomOrdersService roomOrdersService;
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="room")
	public String room(Model model) {
		return "room/room";
	}
	
	//房间预订与入住,实现订单插入功能
//	@RequestMapping(value="roomType1")
//	public String roomType1(@RequestParam(value="roomNum",defaultValue="")String roomNum,
//			@RequestParam(value="userName",defaultValue="")String userName,
//			@RequestParam(value="userId",defaultValue="")String userId,
//			@RequestParam(value="ordersType",defaultValue="")String ordersType,Model model) {
//		//
//		String string="";
//		if ((!userName.equals(null))&&(!userName.equals(""))) {
//			//订单是否插入成功
//			String roomType=Integer.valueOf(ordersType).toString();
//			boolean isInsert=roomService.updateRoomByRoomNum(roomNum, roomType);
//			isInsert= roomOrdersService.insertRoomOrders(roomNum, userName, userId, ordersType);
//			
//			if (isInsert) {
//				string="操作成功!";
//			}else {
//				string="操作失败!";
//			}
//		}
//		List<Room> rooms=roomService.selectRoom("1");		
//		model.addAttribute("rooms", rooms);	
//		model.addAttribute("string", string);
//		return "room/roomType1";
//	}
	//房间预订与入住,实现订单插入功能
		@RequestMapping(value="roomType1")
		public String roomType1(@RequestParam(value="roomNum",defaultValue="")String roomNum,
				@RequestParam(value="userName",defaultValue="")List<String> userName,
				@RequestParam(value="userId",defaultValue="")List<String> userId,
				@RequestParam(value="userTel",defaultValue="")List<String> userTel,
				@RequestParam(value="userNation",defaultValue="")List<String> userNation,
				@RequestParam(value="ordersType",defaultValue="")String ordersType,
				@RequestParam(value="roomPrice",defaultValue="")String roomPrice,
				@RequestParam(value="roomOrdersPrice",defaultValue="")String roomOrdersPrice,Model model) {
			//显示操作是否完成
			String string="";
			boolean isInsert=true;
			if (!(userId.isEmpty())) {
				 for (int i = 0; i < userId.size() - 1; i++)
			        {
					 string = userId.get(i);
			            for (int j = i + 1; j < userId.size(); j++)
			            {
			                if (string.equals(userId.get(j)))
			                {
			                    string="第" + (i + 1) + "位客人跟第" + (j + 1) + "位客人身份证号码重复";
			                    isInsert=false;
			                }
			            }
			        }
				 if (isInsert) {
					
					 int roomOrdersId=roomOrdersService.insertRoomOrders(roomNum,String.valueOf(userId.size()), roomPrice, roomOrdersPrice, ordersType);
					 
					 User user=new User();
					 for(int i=0;i<userId.size();i++) {
						 user.setUserId(userId.get(i));
						 if (i<userNation.size()) {
							 user.setUserNation(userNation.get(i));
						 }
						 if (i<userTel.size()) {
							 user.setUserTel(userTel.get(i));
						 }
						 user.setUserName(userName.get(i));
						 user.setRoomOrdersId(roomOrdersId);
						 isInsert=userService.insertUser(user); 		
					 }
					 String roomType=Integer.valueOf(ordersType).toString();
					 isInsert=roomService.updateRoomByRoomNum(roomNum, roomType);
				}
				 if (isInsert) {
					 string="操作成功!";
				 }else {
					 string="操作失败!"+string;
				 }
			}
			List<Room> rooms=roomService.selectRoom("1");		
			model.addAttribute("rooms", rooms);	
			model.addAttribute("string", string);
			return "room/roomType1";
		}
		
	
	//已入住未退房订单显示页面,实现退房功能
	@RequestMapping(value="roomType2")
	public String roomType2(@RequestParam(value="roomNum",defaultValue="")String roomNum,
			@RequestParam(value="roomType",defaultValue="0")String roomType,
			@RequestParam(value="roomOrdersId",defaultValue="")String roomOrdersId,Model model) {
		String string="";
		if (!roomType.equals("0")) {
			boolean isUpdate=roomService.updateRoomByRoomNum(roomNum, roomType);
			isUpdate=roomOrdersService.updateRoomOrders(roomOrdersId, "00");
			if (isUpdate) {
				string="操作成功!";
			}else {
				string="操作失败!";
			}
		}
		List<RoomOrders> roomOrders=roomOrdersService.selectRoomOrders("02","","","","");
		model.addAttribute("roomOrders", roomOrders);	
		model.addAttribute("string", string);
		return "room/roomType2";
	}
	
	//已预订房间页面,查看已预订未入住房间,并实现入住与退订功能
	@RequestMapping(value="roomType3")
	public String roomType3(@RequestParam(value="roomNum",defaultValue="")String roomNum,
			@RequestParam(value="roomType",defaultValue="0")String roomType,
			@RequestParam(value="roomOrdersId",defaultValue="")String roomOrdersId,Model model) {
		String string="";
		if (!roomType.equals("0")) {
			boolean isUpdate=roomService.updateRoomByRoomNum(roomNum, roomType);
			if (roomType.equals("2")) {
				isUpdate=roomOrdersService.updateRoomOrders(roomOrdersId, "02");
			}else if(roomType.equals("1")){
				isUpdate=roomOrdersService.updateRoomOrders(roomOrdersId, "00");
			}
			if (isUpdate) {
				string="操作成功!";
			}else {
				string="操作失败!";
			}
		}
		List<RoomOrders> roomOrders=roomOrdersService.selectRoomOrders("03","","","","");
		model.addAttribute("roomOrders", roomOrders);	
		model.addAttribute("string", string);
		return "room/roomType3";
	}
	
	//显示正在维护的房间,实现设置为空闲房间的状态
	@RequestMapping(value="roomType4")
	public String roomType4(@RequestParam(value="roomNum",defaultValue="")String roomNum,
			@RequestParam(value="roomType",defaultValue="0")String roomType,
			Model model) {
		String string="";
		if (!roomType.equals("0")) {
			boolean isUpdate=roomService.updateRoomByRoomNum(roomNum.trim(), roomType.trim());
			if (isUpdate) {
				string="操作成功!";
			}else {
				string="操作失败!";
			}
		}
		List<Room> rooms=roomService.selectRoom("4");
		model.addAttribute("rooms", rooms);	
		model.addAttribute("string", string);
		return "room/roomType4";
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
					string="导入房间成功成功";
				}else {
					string="房间导入失败,可能是已有此房间号或者是格式不对,请重新输入一个三位数的数字编号";
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
	
	//房间订单响应
	@RequestMapping(value="{checkRoomOrders,roomType5}")
	public String checkRoomOrders(@RequestParam(value="roomNum",defaultValue="")String roomNum,
			@RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum,
            @RequestParam(value = "pageSize",defaultValue = "5")Integer pageSize,
			@RequestParam(value="startTime",defaultValue="")String startTime,
			@RequestParam(value="userId",defaultValue="")String userId,
			@RequestParam(value="endTime",defaultValue="")String endTime,Model model) {
//		if (userId.equals(null)||userId.equals("")) {
			PageInfo<RoomOrders> roomOrders=roomOrdersService.selectRoomOrders(pageNum, pageSize, "00",userId,roomNum.trim(), startTime.trim(), endTime.trim());
//			System.out.println(roomOrders);
			List<Room> rooms=roomService.selectRoom("");
			model.addAttribute("rooms",rooms);
			model.addAttribute("pagehelper", roomOrders);
//		}
//		if ((!(userId.equals(null))&&(!(userId.equals(""))))){
//			List<User> users=userService.selectUser("00",userId,roomNum.trim(), startTime.trim(), endTime.trim());
//		}	
		return "room/roomType5";
	}
}
