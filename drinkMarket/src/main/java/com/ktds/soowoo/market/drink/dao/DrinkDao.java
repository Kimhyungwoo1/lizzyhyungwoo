package com.ktds.soowoo.market.drink.dao;

import java.util.List;

import com.ktds.soowoo.market.drink.vo.DrinkSearchVO;
import com.ktds.soowoo.market.drink.vo.DrinkVO;

public interface DrinkDao {

	public int selectAllDrinksCount(DrinkSearchVO drinkSearchVO);

	public List<DrinkVO> selectAllDrinks(DrinkSearchVO drinkSearchVO);

	public DrinkVO selectOneDrink(String drinkId);

	public int insertOneDrink(DrinkVO drinkVO);

	public int updateOneDrink(DrinkVO drinkVO);

	public int deleteOneDrink(String drinkId);

}
