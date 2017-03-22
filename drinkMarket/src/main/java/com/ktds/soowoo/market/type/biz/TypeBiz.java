package com.ktds.soowoo.market.type.biz;

import java.util.List;

import com.ktds.soowoo.market.type.vo.TypeVO;

public interface TypeBiz {

	public boolean deleteType(String typeId);
	
	public boolean addType(TypeVO typeVO);
	
	public List<TypeVO> AllTypeList();
	
}
