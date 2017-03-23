package com.ktds.soowoo.market.country.service;

import java.util.List;

import com.ktds.soowoo.market.country.biz.CountryBiz;
import com.ktds.soowoo.market.country.biz.CountryBizImpl;
import com.ktds.soowoo.market.country.vo.CountryVO;

public class CountryServiceImpl implements CountryService{

	private CountryBiz countryBiz;
	
	public CountryServiceImpl() {
		countryBiz = new CountryBizImpl();
	}
	
	@Override
	public boolean addCountry(CountryVO countryVO) {
		return countryBiz.addCountry(countryVO);
	}

	@Override
	public boolean deleteCountry(String countryId) {
		return countryBiz.deleteCountry(countryId);
	}

	@Override
	public List<CountryVO> allListCountry() {
		return countryBiz.allListCountry();
	}

}
