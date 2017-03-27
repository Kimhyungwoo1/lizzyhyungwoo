package com.ktds.soowoo.market.drink.vo;

import com.meister.commom.pager.Pager;
import com.meister.commom.pager.PagerFactory;

public class DrinkSearchVO {

	private Pager pager;
	
	private String typeId;
	private String countryId;

	public Pager getPager() {
		if (pager == null) {
			pager = PagerFactory.getPager(Pager.ORACLE);
		}
		return pager;
	}

	public void setPager(Pager pager) {
		this.pager = pager;
	}

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public String getCountryId() {
		return countryId;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}
	
}
