package com.ktds.soowoo.market.drink.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ktds.soowoo.market.company.vo.CompanyVO;
import com.ktds.soowoo.market.country.vo.CountryVO;
import com.ktds.soowoo.market.drink.vo.DrinkSearchVO;
import com.ktds.soowoo.market.drink.vo.DrinkVO;
import com.ktds.soowoo.market.type.vo.TypeVO;

public class DrinkDaoImpl implements DrinkDao {

	@Override
	public int selectAllDrinksCount(DrinkSearchVO drinkSearchVO) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String oracleUrl = "jdbc:oracle:thin:@localhost:1521:XE";
		
		try {
			conn = DriverManager.getConnection(oracleUrl, "SUL", "sul");
			
			StringBuffer query = new StringBuffer();
			query.append(" SELECT  COUNT(1) CNT "                );
			query.append(" FROM    DRNK D "                       );
			query.append("         , CMPNY CM "                   );
			query.append("         , CNTRY CN "                  );
			query.append("         , TP T "                  );
			query.append(" WHERE   D.CNTRY_ID = CN.CNTRY_ID "      );
			query.append(" AND     D.CMPNY_ID = CM.CMPNY_ID "   );
			query.append(" AND     D.TP_ID = T.TP_ID "   );
			
			if (drinkSearchVO.getCountryId() != null) {
				query.append(" WHERE   D.CNTRY_ID = ? "   );
				
				stmt = conn.prepareStatement(query.toString());
				stmt.setString(1, drinkSearchVO.getCountryId());
			}
			else if (drinkSearchVO.getTypeId() != null) {
				query.append(" WHERE   D.TP_ID = ? "   );
				stmt = conn.prepareStatement(query.toString());
				stmt.setString(1, drinkSearchVO.getTypeId());
			}
			else {
				stmt = conn.prepareStatement(query.toString());
			}
			
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				return rs.getInt("CNT");
			}
			
			return 0;
		}
		catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e1) {
			}
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
			}
			
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
			}
		}
	}
	
	@Override
	public List<DrinkVO> selectAllDrinks(DrinkSearchVO drinkSearchVO) {
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
			conn = DriverManager.getConnection(oracleUrl, "SUL", "sul");

			StringBuffer query = new StringBuffer();
			query.append(" SELECT	*                                       ");
			query.append(" FROM	(                                           ");
			query.append(" 			SELECT	ROWNUM AS RNUM                  ");
			query.append(" 					, A.*                           ");
			query.append(" 			FROM	(                               ");
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
			query.append("         , D.TP_ID                ");
			query.append("         , CM.CMPNY_ID CM_CMPNY_ID   ");
			query.append("         , CM.CMPNY_NM               ");
			query.append("         , CM.LCTN                   ");
			query.append("         , CN.CNTRY_ID CN_CNTRY_ID   ");
			query.append("         , CN.CNTRY_NM               ");
			query.append(" FROM    DRNK D                      ");
			query.append("         , CMPNY CM                  ");
			query.append("         , CNTRY CN                  ");
			query.append(" WHERE   CM.CMPNY_ID = D.CMPNY_ID    ");
			query.append(" AND     CN.CNTRY_ID = D.CNTRY_ID    ");
			
			if (drinkSearchVO.getCountryId() != null) {
				query.append(" WHERE   D.CNTRY_ID = ? "   );
				query.append(" ORDER   BY   PRC   ASC    ");
				query.append(" 					) A                             ");
				query.append(" 			WHERE	ROWNUM <= ?                     ");
				query.append(" 		)                                           ");
				query.append(" WHERE	RNUM >= ?                               ");
				
				stmt = conn.prepareStatement(query.toString());
				stmt.setString(1, drinkSearchVO.getCountryId());
				stmt.setInt(2, drinkSearchVO.getPager().getEndArticleNumber());
				stmt.setInt(3, drinkSearchVO.getPager().getStartArticleNumber());
			}
			else if (drinkSearchVO.getTypeId() != null) {
				query.append(" WHERE   D.TP_ID = ? "   );
				query.append(" ORDER   BY   PRC   ASC    ");
				query.append(" 					) A                             ");
				query.append(" 			WHERE	ROWNUM <= ?                     ");
				query.append(" 		)                                           ");
				query.append(" WHERE	RNUM >= ?                               ");
				
				stmt = conn.prepareStatement(query.toString());
				stmt.setString(1, drinkSearchVO.getTypeId());
				stmt.setInt(2, drinkSearchVO.getPager().getEndArticleNumber());
				stmt.setInt(3, drinkSearchVO.getPager().getStartArticleNumber());
			}
			else {
				query.append(" ORDER   BY   PRC   ASC    ");
				query.append(" 					) A                             ");
				query.append(" 			WHERE	ROWNUM <= ?                     ");
				query.append(" 		)                                           ");
				query.append(" WHERE	RNUM >= ?                               ");
				
				stmt = conn.prepareStatement(query.toString());
				stmt.setInt(1, drinkSearchVO.getPager().getEndArticleNumber());
				stmt.setInt(2, drinkSearchVO.getPager().getStartArticleNumber());
			}
			
			/*query.append(" ORDER   BY   PRC   ASC    ");
			query.append(" 					) A                             ");
			query.append(" 			WHERE	ROWNUM <= ?                     ");
			query.append(" 		)                                           ");
			query.append(" WHERE	RNUM >= ?                               ");

			stmt = conn.prepareStatement(query.toString());
			stmt.setInt(1, drinkSearchVO.getPager().getEndArticleNumber());
			stmt.setInt(2, drinkSearchVO.getPager().getStartArticleNumber());*/
			
			rs = stmt.executeQuery();
			
			List<DrinkVO> drinkList = new ArrayList<DrinkVO>();
			DrinkVO drinkVO = null;
			CountryVO countryVO = null;
			CompanyVO companyVO = null;
			TypeVO typeVO = null;
			
			while (rs.next()) {
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
				drinkVO.setDrinkType(rs.getString("TP_ID"));
				
				countryVO = drinkVO.getCountryVO();
				countryVO.setCountryId(rs.getString("CN_CNTRY_ID"));
				countryVO.setCountryName(rs.getString("CNTRY_NM"));
				
				companyVO = drinkVO.getCompanyVO();
				companyVO.setCompanyId(rs.getString("CM_CMPNY_ID"));
				companyVO.setCompanyName(rs.getString("CMPNY_NM"));
				companyVO.setLocation(rs.getString("LCTN"));
				
				typeVO = drinkVO.getTypeVO();
				typeVO.setTypeId(rs.getString("T_TP_ID"));
				typeVO.setTypeName(rs.getString("TP_NM"));
				
				drinkList.add(drinkVO);
			}
			
			return drinkList;
		} 
		catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
			}
			
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
			}
			
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
			}
		}
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
			conn = DriverManager.getConnection(oracleUrl, "SUL", "sul");

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
			query.append("         , D.TP_ID                ");
			query.append("         , CM.CMPNY_ID CM_CMPNY_ID   ");
			query.append("         , CM.CMPNY_NM               ");
			query.append("         , CM.LCTN                   ");
			query.append("         , CN.CNTRY_ID CN_CNTRY_ID   ");
			query.append("         , CN.CNTRY_NM               ");
			query.append("         , T.TP_ID T_TP_ID               ");
			query.append("         , T.TP_NM               ");
			query.append(" FROM    DRNK D                      ");
			query.append("         , CMPNY CM                  ");
			query.append("         , CNTRY CN                  ");
			query.append("         , TP T                  ");
			query.append(" WHERE   DRNK_ID = ?                 ");
			query.append(" AND     CM.CMPNY_ID = D.CMPNY_ID    ");
			query.append(" AND     CN.CNTRY_ID = D.CNTRY_ID    ");

			stmt = conn.prepareStatement(query.toString());
			stmt.setString(1, drinkId);
			
			rs = stmt.executeQuery();
			DrinkVO drinkVO = null;
			CountryVO countryVO = null;
			CompanyVO companyVO = null;
			TypeVO typeVO = null;
			
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
				drinkVO.setDrinkType(rs.getString("TP_ID"));
				
				countryVO = drinkVO.getCountryVO();
				countryVO.setCountryId(rs.getString("CN_CNTRY_ID"));
				countryVO.setCountryName(rs.getString("CNTRY_NM"));
				
				companyVO = drinkVO.getCompanyVO();
				companyVO.setCompanyId(rs.getString("CM_CMPNY_ID"));
				companyVO.setCompanyName(rs.getString("CMPNY_NM"));
				companyVO.setLocation(rs.getString("LCTN"));
				
				typeVO = drinkVO.getTypeVO();
				typeVO.setTypeId(rs.getString("T_TP_ID"));
				typeVO.setTypeName(rs.getString("TP_NM"));
			}
			
			return drinkVO;
		} 
		catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
			}
			
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
			}
			
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
			}
		}
	}

	@Override
	public int insertOneDrink(DrinkVO drinkVO) {
		try {
			Class.forName("oracle.jdbc.driver.oracleDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage(), e);
		}

		Connection conn = null;
		PreparedStatement stmt = null;

		String oracleUrl = "jdbc:oracle:thin:@localhost:1521:XE";

		try {
			conn = DriverManager.getConnection(oracleUrl, "SUL", "sul");

			StringBuffer query = new StringBuffer();
			query.append(" INSERT  INTO    DRNK    {               ");
			query.append(" 			                DRNK_ID        ");
			query.append(" 			                , DRNK_NM      ");
			query.append(" 			                , CNTRY_ID     ");
			query.append(" 			                , ML           ");
			query.append(" 			                , DGR          ");
			query.append(" 			                , PRC          ");
			query.append(" 			                , QNTTY        ");
			query.append(" 			                , IMG          ");
			query.append(" 			                , DTL          ");
			query.append(" 			                , PNT_PCT      ");
			query.append(" 			                , BY_CNT       ");
			query.append(" 			                , CMPNY_ID     ");
			query.append(" 			                , TP_ID        ");
			query.append(" 			            }                  ");
			query.append(" 			    VALUES  {                  ");
			query.append(" 			                'D-' || TO_CHAR(SYSDATE, 'YYYYMMDDHH24') || '-' || LPAD(ARTST_ID_SEQ.NEXTVAL, 6, '0')              ");
			query.append(" 			                , ?            ");
			query.append(" 			                , ?            ");
			query.append(" 			                , ?            ");
			query.append(" 			                , ?            ");
			query.append(" 			                , ?            ");
			query.append(" 			                , ?            ");
			query.append(" 			                , ?            ");
			query.append(" 			                , ?            ");
			query.append(" 			                , 0.01         ");
			query.append(" 			                , 0            ");
			query.append(" 			                , ?            ");
			query.append(" 			                , ?            ");
			query.append(" 			            }                  ");
			
			stmt = conn.prepareStatement(query.toString());
			stmt.setString(1, drinkVO.getDrinkName());
			stmt.setString(2, drinkVO.getCountryId());
			stmt.setInt(3, drinkVO.getMl());
			stmt.setDouble(4, drinkVO.getDegree());
			stmt.setInt(5, drinkVO.getPrice());
			stmt.setInt(6, drinkVO.getQuantity());
			stmt.setString(7, drinkVO.getImage());
			stmt.setString(8, drinkVO.getDetail());
			stmt.setDouble(9, drinkVO.getPointPct());
			stmt.setInt(10, drinkVO.getBuyCount());
			
			return stmt.executeUpdate();
		} 
		catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
			}
			
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
			}
		}
	}

	@Override
	public int updateOneDrink(DrinkVO drinkVO) {
		try {
			Class.forName("oracle.jdbc.driver.oracleDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage(), e);
		}

		Connection conn = null;
		PreparedStatement stmt = null;

		String oracleUrl = "jdbc:oracle:thin:@localhost:1521:XE";

		try {
			conn = DriverManager.getConnection(oracleUrl, "SUL", "sul");

			StringBuffer query = new StringBuffer();
			query.append(" UPDATE  DRNK             ");
			query.append(" SET                      ");
			query.append("         DRNK_NM = ?      ");
			query.append("         , CNTRY_ID = ?   ");
			query.append("         , ML = ?         ");
			query.append("         , DGR = ?        ");
			query.append("         , PRC = ?        ");
			query.append("         , QNTTY = ?      ");
			query.append("         , DTL = ?        ");
			query.append("         , PNT_PCT = ?    ");
			query.append("         , BY_CNT = ?     ");
			query.append(" WHERE   DRNK_ID = ?      ");
			
			stmt = conn.prepareStatement(query.toString());
			stmt.setString(1, drinkVO.getDrinkName());
			stmt.setString(2, drinkVO.getCountryId());
			stmt.setInt(3, drinkVO.getMl());
			stmt.setDouble(4, drinkVO.getDegree());
			stmt.setInt(5, drinkVO.getPrice());
			stmt.setInt(6, drinkVO.getQuantity());
			stmt.setString(7, drinkVO.getDetail());
			stmt.setDouble(8, drinkVO.getPointPct());
			stmt.setInt(9, drinkVO.getBuyCount());
			stmt.setString(10, drinkVO.getDrinkId());
			
			return stmt.executeUpdate();
		} 
		catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
			}
			
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
			}
		}
	}

	@Override
	public int deleteOneDrink(String drinkId) {
		try {
			Class.forName("oracle.jdbc.driver.oracleDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage(), e);
		}

		Connection conn = null;
		PreparedStatement stmt = null;

		String oracleUrl = "jdbc:oracle:thin:@localhost:1521:XE";

		try {
			conn = DriverManager.getConnection(oracleUrl, "SUL", "sul");

			StringBuffer query = new StringBuffer();
			query.append(" DELETE               ");
			query.append(" FROM    DRNK         ");
			query.append(" WHERE   DRNK_ID = ?  ");
			
			stmt = conn.prepareStatement(query.toString());
			stmt.setString(1, drinkId);
			
			return stmt.executeUpdate();
		} 
		catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
			}
			
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
			}
		}
	}

}
