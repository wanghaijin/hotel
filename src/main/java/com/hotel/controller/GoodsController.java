package com.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.hotel.pojo.Goods;
import com.hotel.pojo.GoodsOrders;
import com.hotel.service.GoodsOrdersService;
import com.hotel.service.GoodsService;

@Controller
public class GoodsController {
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private GoodsOrdersService goodsOrdersService;
	
	@RequestMapping(value="goods")
	public String goods() {
		return "goods/goods";
	}
	
	//商品订单
	@RequestMapping(value="goodsOrders")
	public String goodsOrders(@RequestParam(value="goodsName",defaultValue="0")String goodsName,
			@RequestParam(value="goodsOrdersAmount",defaultValue="x")String goodsOrdersAmount,
			Model model) {
		//是否导入订单
		boolean isInsert=false;
		if ((!goodsName.equals("0"))&&(!goodsOrdersAmount.equals("x"))) {
			//插入商品,存在则不插入
			goodsService.insertGoods(goodsName);
			//生成订单数据
			List<Goods> goods=goodsService.selectGoods(goodsName);
			GoodsOrders goodsOrders=new GoodsOrders();
			goodsOrders.setGoodsOrdersAmount(Integer.valueOf(goodsOrdersAmount.trim()));
			for(Goods good:goods) {
				goodsOrders.setGoodsId(good.getGoodsId());
			}
			//导入订单
			isInsert=goodsOrdersService.insertGoodsOrders(goodsOrders);	
		}
		if(isInsert) {
			String info="此条记录以导入账本,可以继续导入";
			model.addAttribute("info", info);
		}
//		List<GoodsOrders>goodsOrders= goodsOrdersService.selectGoodsOrders(goodsId);
//		model.addAttribute("goodsOrders", goodsOrders);
		return "goods/goodsOrders";
	}
	
	//改变商品状态或者添加商品
	@RequestMapping(value="goodsOrdersShow")
	public String goodsChange(@RequestParam(value="pageNum",defaultValue="1")int pageNum,
			@RequestParam(value="pageSize",defaultValue="10")int pageSize,
			@RequestParam(value="goodsId",defaultValue="")String goodsId,Model model) {
		PageInfo<GoodsOrders> pageInfo=goodsOrdersService.selectGoodsOrders(goodsId, pageNum, pageSize);
		model.addAttribute("pageInfo", pageInfo);
//		model.addAttribute("goodsOrders", goodsOrdersService.selectGoodsOrders(goodsId, pageNum, pageSize));
		return "goods/goodsOrdersShow";
	}
	
}
