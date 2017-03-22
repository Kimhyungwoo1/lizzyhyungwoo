package com.ktds.soowoo.market.company.service;

import com.ktds.soowoo.market.company.biz.CompanyBiz;
import com.ktds.soowoo.market.company.biz.CompanyBizImpl;
import com.ktds.soowoo.market.company.vo.CompanyVO;

public class CompanyServiceImpl implements CompanyService{

	private CompanyBiz companyBiz;
	
	public CompanyServiceImpl() {
		companyBiz = new CompanyBizImpl();
	}
	
	@Override
	public boolean addCompany(CompanyVO companyVO) {
		return companyBiz.addCompany(companyVO);
	}

	@Override
	public boolean deleteCompany(String companyId) {
		return companyBiz.deleteCompany(companyId);
	}

}
