package com.ktds.soowoo.market.company.biz;

import com.ktds.soowoo.market.company.dao.CompanyDao;
import com.ktds.soowoo.market.company.dao.CompanyDaoImpl;
import com.ktds.soowoo.market.company.vo.CompanyVO;

public class CompanyBizImpl implements CompanyBiz{

	private CompanyDao companyDao;
	
	public CompanyBizImpl() {
		companyDao = new CompanyDaoImpl();
	}
	
	@Override
	public boolean addCompany(CompanyVO companyVO) {
		return companyDao.insertCompany(companyVO) > 0;
	}

	@Override
	public boolean deleteCompany(String companyId) {
		return companyDao.deleteCompany(companyId) > 0;
	}

}
