package com.hotel.pojo;
//订单

import java.sql.Timestamp;

public class GoodsOrders {
	private int goodsOrdersId;
	//商品id
	private int goodsId;
	//商品
	private Goods goods;
	//订单日期
	private Timestamp goodsOrdersTime;
	//商品购买数量
	private int goodsOrdersAmount;
	public int getGoodsOrdersId() {
		return goodsOrdersId;
	}
	public void setGoodsOrdersId(int goodsOrdersId) {
		this.goodsOrdersId = goodsOrdersId;
	}
	public int getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public Timestamp getGoodsOrdersTime() {
		return goodsOrdersTime;
	}
	public void setGoodsOrdersTime(Timestamp goodsOrdersTime) {
		this.goodsOrdersTime = goodsOrdersTime;
	}
	public int getGoodsOrdersAmount() {
		return goodsOrdersAmount;
	}
	public void setGoodsOrdersAmount(int goodsOrdersAmount) {
		this.goodsOrdersAmount = goodsOrdersAmount;
	}
	@Override
	public String toString() {
		return "GoodsOrders [goodsOrdersId=" + goodsOrdersId + ", goodsId=" + goodsId + ", goods=" + goods
				+ ", goodsOrdersTime=" + goodsOrdersTime + ", goodsOrdersAmount=" + goodsOrdersAmount + "]";
	}
	
	
}
