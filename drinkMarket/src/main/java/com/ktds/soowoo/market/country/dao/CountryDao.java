package com.ktds.soowoo.market.country.dao;

import com.ktds.soowoo.market.country.vo.CountryVO;

public interface CountryDao {

	public int insertCountry(CountryVO countryVO);
	
	public int deleteCountry(String countryId);
	
	public CountryVO selectOneCountry(String countryId);
	
}
