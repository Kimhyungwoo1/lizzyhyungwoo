package com.ktds.soowoo.market.type.service;

import java.util.List;

import com.ktds.soowoo.market.type.biz.TypeBiz;
import com.ktds.soowoo.market.type.biz.TypeBizImpl;
import com.ktds.soowoo.market.type.vo.TypeVO;

public class TypeServiceImpl implements TypeService{

	private TypeBiz typeBiz;
	
	public TypeServiceImpl () {
		typeBiz = new TypeBizImpl();
	}
	
	@Override
	public boolean deleteType(String typeId) {
		return typeBiz.deleteType(typeId);
	}

	@Override
	public boolean addType(TypeVO typeVO) {
		return typeBiz.addType(typeVO);
	}

	@Override
	public List<TypeVO> AllTypeList() {
		return typeBiz.AllTypeList();
	}

}
