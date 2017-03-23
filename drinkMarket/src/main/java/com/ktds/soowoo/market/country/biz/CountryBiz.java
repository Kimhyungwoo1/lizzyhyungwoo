package com.ktds.soowoo.market.country.biz;

import java.util.List;

import com.ktds.soowoo.market.country.vo.CountryVO;

public interface CountryBiz {
	
	public boolean addCountry(CountryVO countryVO);
	
	public boolean deleteCountry(String countryId);
	
	public List<CountryVO> allListCountry();

}
