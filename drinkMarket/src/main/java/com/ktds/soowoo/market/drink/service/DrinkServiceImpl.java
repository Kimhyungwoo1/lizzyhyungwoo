package com.ktds.soowoo.market.drink.service;

import java.util.List;

import com.ktds.soowoo.market.drink.biz.DrinkBiz;
import com.ktds.soowoo.market.drink.biz.DrinkBizImpl;
import com.ktds.soowoo.market.drink.vo.DrinkSearchVO;
import com.ktds.soowoo.market.drink.vo.DrinkVO;

public class DrinkServiceImpl implements DrinkService {
	
	private DrinkBiz drinkBiz;
	
	public DrinkServiceImpl() {
		drinkBiz = new DrinkBizImpl();
	}

	@Override
	public List<DrinkVO> getAllDrinks(DrinkSearchVO drinkSearchVO) {
		return drinkBiz.getAllDrinks(drinkSearchVO);
	}

	@Override
	public DrinkVO getOneDrink(String drinkId) {
		return drinkBiz.getOneDrink(drinkId);
	}

	@Override
	public boolean addOneDrink(DrinkVO drinkVO) {
		return drinkBiz.addOneDrink(drinkVO);
	}

	@Override
	public boolean modifyOneDrink(DrinkVO drinkVO) {
		return drinkBiz.modifyOneDrink(drinkVO);
	}

	@Override
	public boolean deleteOneDrink(String drinkId) {
		return drinkBiz.deleteOneDrink(drinkId);
	}

}
