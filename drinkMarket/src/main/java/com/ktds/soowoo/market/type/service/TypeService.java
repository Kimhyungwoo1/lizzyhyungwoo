package com.ktds.soowoo.market.type.service;

import java.util.List;

import com.ktds.soowoo.market.type.vo.TypeVO;

public interface TypeService {

	public boolean deleteType(String typeId);

	public boolean addType(TypeVO typeVO);

	public List<TypeVO> AllTypeList();

}
