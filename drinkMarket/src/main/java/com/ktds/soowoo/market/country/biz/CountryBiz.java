package com.ktds.soowoo.market.country.biz;

import com.ktds.soowoo.market.country.vo.CountryVO;

public interface CountryBiz {
	
	public boolean addCountry(CountryVO countryVO);
	
	public boolean deleteCountry(String countryId);
	
	public CountryVO getOneCountry(String countryId);

}
