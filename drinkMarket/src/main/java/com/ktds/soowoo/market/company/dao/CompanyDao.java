package com.ktds.soowoo.market.company.dao;

import com.ktds.soowoo.market.company.vo.CompanyVO;

public interface CompanyDao {
	
	public int insertCompany(CompanyVO companyVO);
	
	public int deleteCompany(String companyId);
	
}
