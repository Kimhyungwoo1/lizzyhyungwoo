package com.ktds.soowoo.market.drink.service;

import java.util.List;

import com.ktds.soowoo.market.drink.vo.DrinkSearchVO;
import com.ktds.soowoo.market.drink.vo.DrinkVO;

public interface DrinkService {
	
public List<DrinkVO> getAllDrinks(DrinkSearchVO drinkSearchVO);
	
	public DrinkVO getOneDrink(String drinkId);
	
	public boolean addOneDrink(DrinkVO drinkVO);
	
	public boolean modifyOneDrink(DrinkVO drinkVO);
	
	public boolean deleteOneDrink(String drinkId);
	
}
