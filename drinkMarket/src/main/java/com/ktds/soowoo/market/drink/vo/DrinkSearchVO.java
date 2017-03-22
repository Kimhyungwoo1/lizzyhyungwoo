package com.ktds.soowoo.market.drink.vo;

import com.ktds.soowoo.market.common.web.pager.Pager;
import com.ktds.soowoo.market.common.web.pager.PagerFactory;

public class DrinkSearchVO {

	private Pager pager;

	public Pager getPager() {
		if (pager == null) {
			pager = PagerFactory.getPager(Pager.ORACLE);
		}
		return pager;
	}

	public void setPager(Pager pager) {
		this.pager = pager;
	}
	
}
