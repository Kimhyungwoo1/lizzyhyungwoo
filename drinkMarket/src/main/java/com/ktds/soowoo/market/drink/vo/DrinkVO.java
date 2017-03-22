package com.ktds.soowoo.market.drink.vo;

import com.ktds.soowoo.market.company.vo.CompanyVO;
import com.ktds.soowoo.market.country.vo.CountryVO;
import com.ktds.soowoo.market.type.vo.TypeVO;

public class DrinkVO {
	
	private String drinkId;
	private String drinkName;
	private String companyId;
	private String countryId;
	private int ml;
	private double degree;
	private int price;
	private int quantity;
	private String image;
	private String detail;
	private double pointPct;
	private int buyCount;
	private String drinkType;
	
	private CompanyVO companyVO;
	private CountryVO countryVO;
	private TypeVO typeVO;
	
	public String getDrinkId() {
		return drinkId;
	}
	
	public void setDrinkId(String drinkId) {
		this.drinkId = drinkId;
	}
	
	public String getDrinkName() {
		return drinkName;
	}
	
	public void setDrinkName(String drinkName) {
		this.drinkName = drinkName;
	}
	
	public String getCompanyId() {
		return companyId;
	}
	
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	
	public String getCountryId() {
		return countryId;
	}
	
	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}
	
	public int getMl() {
		return ml;
	}
	
	public void setMl(int ml) {
		this.ml = ml;
	}
	
	public double getDegree() {
		return degree;
	}
	
	public void setDegree(double degree) {
		this.degree = degree;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public String getImage() {
		return image;
	}
	
	public void setImage(String image) {
		this.image = image;
	}
	
	public String getDetail() {
		return detail;
	}
	
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	public double getPointPct() {
		return pointPct;
	}
	
	public void setPointPct(double pointPct) {
		this.pointPct = pointPct;
	}
	
	public int getBuyCount() {
		return buyCount;
	}
	
	public void setBuyCount(int buyCount) {
		this.buyCount = buyCount;
	}
	
	public String getDrinkType() {
		return drinkType;
	}

	public void setDrinkType(String drinkType) {
		this.drinkType = drinkType;
	}

	public CompanyVO getCompanyVO() {
		if (companyVO == null) {
			companyVO =  new CompanyVO();
		}
		return companyVO;
	}

	public void setCompanyVO(CompanyVO companyVO) {
		this.companyVO = companyVO;
	}

	public CountryVO getCountryVO() {
		if (countryVO == null) {
			countryVO = new CountryVO();
		}
		return countryVO;
	}

	public void setCountryVO(CountryVO countryVO) {
		this.countryVO = countryVO;
	}

	public TypeVO getTypeVO() {
		if (typeVO == null) {
			typeVO = new TypeVO();
		}
		return typeVO;
	}

	public void setTypeVO(TypeVO typeVO) {
		this.typeVO = typeVO;
	}
	
}
