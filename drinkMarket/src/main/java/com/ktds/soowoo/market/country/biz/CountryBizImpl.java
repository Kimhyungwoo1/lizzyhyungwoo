package com.ktds.soowoo.market.country.biz;

import java.util.List;

import com.ktds.soowoo.market.country.dao.CountryDao;
import com.ktds.soowoo.market.country.dao.CountryDaoImpl;
import com.ktds.soowoo.market.country.vo.CountryVO;

public class CountryBizImpl implements CountryBiz{

	private CountryDao countryDao;
	
	public CountryBizImpl() {
		countryDao = new CountryDaoImpl();
	}
	
	@Override
	public boolean addCountry(CountryVO countryVO) {
		return countryDao.insertCountry(countryVO) > 0;
	}

	@Override
	public boolean deleteCountry(String countryId) {
		return countryDao.deleteCountry(countryId) > 0;
	}

	@Override
	public List<CountryVO> allListCountry() {
		return countryDao.getAllListCountry();
	}

}
