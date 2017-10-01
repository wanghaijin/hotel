package com.hotel.mapper;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hotel.pojo.Room;
import com.hotel.pojo.RoomOrders;
import com.hotel.pojo.RoomSize;

public class RoomMapperTest {
	private RoomMapper roomMapper;
	private RoomOrdersMapper roomOrdersMapper;

	@Before
	public void setUp() throws Exception {
		ApplicationContext context=new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
		roomOrdersMapper=context.getBean(RoomOrdersMapper.class);
		
		
	}

	@Test
	public void testSelectRoom() {
		String string="123";
		String string2=string.substring(0, 2);
		System.out.println(string.substring(0, 2));
//		List<RoomOrders> roomOrders=roomOrdersMapper.selectRoomOrders(null, null, null);
//		System.out.println(roomOrders);
//		roomMapper.selectRoom("1");
//		fail("Not yet implemented");
//		List<Room> rooms=roomMapper.selectRoom("", "1", "0");
//		System.out.println(rooms);
	}

	@Test
	public void testUpdateRoomByRoomNum() {
//		fail("Not yet implemented");
//		roomMapper.updateRoomByRoomNum("101", "1");
	}

	@Test
	public void testInsertRoom() {
//		Room room=new Room();
//		RoomType roomType=new RoomType();
//		roomType.setTypeId("1");
//		RoomSize roomSize=new RoomSize();
//		roomSize.setSizeId("1");
//		room.setRoomSize(roomSize);
//		room.setRoomType(roomType);
//		for(int i=1;i<=9;i++) {
//			room.setRoomNum("10"+i);
//			roomMapper.insertRoom(room);
//			
//		}
//		room.setRoomType("0");
//		room.setRoomFloor("1");
//		fail("Not yet implemented");
	}

}
