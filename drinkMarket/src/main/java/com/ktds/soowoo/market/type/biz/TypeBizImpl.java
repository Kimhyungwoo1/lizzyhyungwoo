package com.ktds.soowoo.market.type.biz;

import java.util.List;

import com.ktds.soowoo.market.type.dao.TypeDao;
import com.ktds.soowoo.market.type.dao.TypeDaoImpl;
import com.ktds.soowoo.market.type.vo.TypeVO;

public class TypeBizImpl implements TypeBiz{

	private TypeDao typeDao;
	
	public TypeBizImpl() {
		typeDao = new TypeDaoImpl();
	}
	
	@Override
	public boolean deleteType(String typeId) {
		return typeDao.deleteType(typeId) > 0;
	}

	@Override
	public boolean addType(TypeVO typeVO) {
		return typeDao.insertType(typeVO) > 0;
	}

	@Override
	public List<TypeVO> AllTypeList() {
		return typeDao.getAllTypeList();
	}

}
