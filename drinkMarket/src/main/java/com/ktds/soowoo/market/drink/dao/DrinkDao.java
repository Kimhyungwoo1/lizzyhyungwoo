package com.ktds.soowoo.market.drink.dao;

import java.util.List;

import com.ktds.soowoo.market.drink.vo.DrinkSearchVO;
import com.ktds.soowoo.market.drink.vo.DrinkVO;

public interface DrinkDao {

	public List<DrinkVO> selectAllDrinks(DrinkSearchVO drinkSearchVO);
	
	public DrinkVO selectOneDrink(String drinkId);
	
	public int insertOneDrink(DrinkVO drinkVO);
	
	public int updateOneDrink(String drinkId);
	
	public int deleteOneDrink(String drinkId);
	
	
}
