package com.ktds.soowoo.market.country.vo;

import com.ktds.soowoo.market.drink.vo.DrinkVO;

public class CountryVO {

	private String countryId;
	private String countryName;
	private DrinkVO drinkVO;

	public DrinkVO getDrinkVO() {
		if ( drinkVO == null ){
			drinkVO = new DrinkVO();
		}
		return drinkVO;
	}

	public void setDrinkVO(DrinkVO drinkVO) {
		this.drinkVO = drinkVO;
	}

	public String getCountryId() {
		return countryId;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

}
