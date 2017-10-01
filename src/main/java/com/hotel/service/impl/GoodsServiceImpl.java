package com.hotel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.mapper.GoodsMapper;
import com.hotel.pojo.Goods;
import com.hotel.service.GoodsService;
@Service
public class GoodsServiceImpl implements GoodsService {
	
	@Autowired
	private GoodsMapper goodsMapper;
	@Override
	public List<Goods> selectGoods(String goodsName) {
		// TODO Auto-generated method stub
		List<Goods> goods=goodsMapper.selectGoods(goodsName);
		return goods;
	}

	@Override
	public boolean insertGoods(String goodsName) {
		// TODO Auto-generated method stub
		List<Goods> allGoods=goodsMapper.selectGoods(null);
		//�жϴ洢����Ʒ���ݿ����Ƿ����
		for(Goods good:allGoods) {
			if (good.getGoodsName().equals(goodsName)) {
				return false;
			}
		}
		//��������
		Goods goods=new Goods();
		goods.setGoodsName(goodsName);
		int changeLine=goodsMapper.insertGoods(goods);
		//�����Ƿ�ɹ�
		if(changeLine != 0) {
			return true;
		}
		return false;
	}

}
