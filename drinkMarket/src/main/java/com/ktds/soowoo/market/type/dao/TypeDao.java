package com.ktds.soowoo.market.type.dao;

import java.util.List;

import com.ktds.soowoo.market.type.vo.TypeVO;

public interface TypeDao {

	public int insertType(TypeVO typeVO);
	
	public int deleteType(String typeId);
	
	public List<TypeVO> getAllTypeList();
	
}
