package com.ktds.soowoo.market.drink.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ktds.soowoo.market.company.vo.CompanyVO;
import com.ktds.soowoo.market.country.vo.CountryVO;
import com.ktds.soowoo.market.drink.vo.DrinkSearchVO;
import com.ktds.soowoo.market.drink.vo.DrinkVO;

public class DrinkDaoImpl implements DrinkDao {

	@Override
	public List<DrinkVO> selectAllDrinks(DrinkSearchVO drinkSearchVO) {
		return null;
	}

	@Override
	public DrinkVO selectOneDrink(String drinkId) {
		try {
			Class.forName("oracle.jdbc.driver.oracleDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage(), e);
		}

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String oracleUrl = "jdbc:oracle:thin:@localhost:1521:XE";

		try {
			conn = DriverManager.getConnection(oracleUrl);

			StringBuffer query = new StringBuffer();
			query.append(" SELECT  D.DRNK_ID                   ");
			query.append("         , D.DRNK_NM                 ");
			query.append("         , D.CNTRY_ID                ");
			query.append("         , D.ML                      ");
			query.append("         , D.DGR                     ");
			query.append("         , D.PRC                     ");
			query.append("         , D.QNTTY                   ");
			query.append("         , D.IMG                     ");
			query.append("         , D.DTL                     ");
			query.append("         , D.PNT_PCT                 ");
			query.append("         , D.BY_CNT                  ");
			query.append("         , D.CMPNY_ID                ");
			query.append("         , CM.CMPNY_ID CM_CMPNY_ID   ");
			query.append("         , CM.CMPNY_NM               ");
			query.append("         , CM.LCTN                   ");
			query.append("         , CN.CNTRY_ID CN_CNTRY_ID   ");
			query.append("         , CN.CNTRY_NM               ");
			query.append(" FROM    DRNK D                      ");
			query.append("         , CMPNY CM                  ");
			query.append("         , CNTRY CN                  ");
			query.append(" WHERE   DRNK_ID = ?                 ");
			query.append(" AND     CM.CMPNY_ID = D.CMPNY_ID    ");
			query.append(" AND     CN.CNTRY_ID = D.CNTRY_ID    ");

			stmt = conn.prepareStatement(query.toString());
			stmt.setString(1, drinkId);
			
			rs = stmt.executeQuery();
			DrinkVO drinkVO = null;
			CountryVO countryVO = null;
			CompanyVO companyVO = null;
			
			if (rs.next()) {
				drinkVO = new DrinkVO();
				drinkVO.setDrinkId(rs.getString("DRNK_ID"));
				drinkVO.setDrinkName(rs.getString("DRNK_NM"));
				drinkVO.setCountryId(rs.getString("CNTRY_ID"));
				drinkVO.setMl(rs.getInt("ML"));
				drinkVO.setDegree(rs.getDouble("DGR"));
				drinkVO.setPrice(rs.getInt("PRC"));
				drinkVO.setQuantity(rs.getInt("QNTTY"));
				drinkVO.setImage(rs.getString("IMG"));
				drinkVO.setDetail(rs.getString("DTL"));
				drinkVO.setPointPct(rs.getDouble("PNT_PCT"));
				drinkVO.setBuyCount(rs.getInt("BY_CNT"));
				drinkVO.setCompanyId(rs.getString("CMPNY_ID"));
				
				countryVO = new CountryVO();
				
				companyVO = new CompanyVO();
			}
			
			return drinkVO;

		} 
		catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally {
			try {
				if ()
				rs.close();
			} catch (SQLException e) {
			}
			
			try {
				stmt.close();
			} catch (SQLException e) {
			}
			
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}

	}

	@Override
	public int insertOneDrink(DrinkVO drinkVO) {
		return 0;
	}

	@Override
	public int updateOneDrink(String drinkId) {
		return 0;
	}

	@Override
	public int deleteOneDrink(String drinkId) {
		return 0;
	}

}
