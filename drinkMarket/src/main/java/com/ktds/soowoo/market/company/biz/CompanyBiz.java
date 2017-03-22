package com.ktds.soowoo.market.company.biz;

import com.ktds.soowoo.market.company.vo.CompanyVO;

public interface CompanyBiz {

	public boolean addCompany(CompanyVO companyVO);
	
	public boolean deleteCompany(String companyId);
	
}
