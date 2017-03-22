package com.ktds.soowoo.market.country.service;

import com.ktds.soowoo.market.country.vo.CountryVO;

public interface CountryService {

	public boolean addCountry(CountryVO countryVO);

	public boolean deleteCountry(String countryId);

	public CountryVO getOneCountry(String countryId);

}
