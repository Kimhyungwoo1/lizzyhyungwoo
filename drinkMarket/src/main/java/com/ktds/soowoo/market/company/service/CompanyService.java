package com.ktds.soowoo.market.company.service;

import com.ktds.soowoo.market.company.vo.CompanyVO;

public interface CompanyService {

public boolean addCompany(CompanyVO companyVO);
	
	public boolean deleteCompany(String companyId);
	
}
