package com.hotel.pojo;
//����

import java.sql.Timestamp;

public class GoodsOrders {
	private int goodsOrdersId;
	//��Ʒid
	private int goodsId;
	//��Ʒ
	private Goods goods;
	//��������
	private Timestamp goodsOrdersTime;
	//��Ʒ��������
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
