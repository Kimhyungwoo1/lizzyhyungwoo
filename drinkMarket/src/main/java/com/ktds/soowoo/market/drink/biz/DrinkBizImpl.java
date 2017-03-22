package com.ktds.soowoo.market.drink.biz;

import java.util.ArrayList;
import java.util.List;

import com.ktds.soowoo.market.common.web.pager.Pager;
import com.ktds.soowoo.market.drink.dao.DrinkDao;
import com.ktds.soowoo.market.drink.dao.DrinkDaoImpl;
import com.ktds.soowoo.market.drink.vo.DrinkSearchVO;
import com.ktds.soowoo.market.drink.vo.DrinkVO;

public class DrinkBizImpl implements DrinkBiz {
	
	private DrinkDao drinkDao;
	
	public DrinkBizImpl() {
		drinkDao = new DrinkDaoImpl();
	}

	@Override
	public List<DrinkVO> getAllDrinks(DrinkSearchVO drinkSearchVO) {
		int drinkCount = drinkDao.selectAllDrinksCount(drinkSearchVO);
		
		Pager pager = drinkSearchVO.getPager();
		pager.setTotalArticleCount(drinkCount);
		
		if (drinkCount == 0) {
			return new ArrayList<DrinkVO>();
		}
		
		return drinkDao.selectAllDrinks(drinkSearchVO);
	}

	@Override
	public DrinkVO getOneDrink(String drinkId) {
		return drinkDao.selectOneDrink(drinkId);
	}

	@Override
	public boolean addOneDrink(DrinkVO drinkVO) {
		return drinkDao.insertOneDrink(drinkVO) > 0;
	}

	@Override
	public boolean modifyOneDrink(DrinkVO drinkVO) {
		return drinkDao.updateOneDrink(drinkVO) > 0;
	}

	@Override
	public boolean deleteOneDrink(String drinkId) {
		return drinkDao.deleteOneDrink(drinkId) > 0;
	}

}
