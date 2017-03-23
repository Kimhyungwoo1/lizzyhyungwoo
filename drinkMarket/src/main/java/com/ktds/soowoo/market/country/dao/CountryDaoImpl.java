package com.ktds.soowoo.market.country.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ktds.soowoo.market.country.vo.CountryVO;

public class CountryDaoImpl implements CountryDao {

	private String oracleUrl = "jdbc:oracle:thin:@192.168.201.29:1521:XE";

	@Override
	public int insertCountry(CountryVO countryVO) {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage(), e);
		}

		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = DriverManager.getConnection(oracleUrl, "SUL", "sul");

			StringBuffer query = new StringBuffer();
			query.append(" INSERT	INTO	CNTRY	( ");
			query.append(" 							CNTRY_ID ");
			query.append(" 							, CNTRY_NM ");
			query.append(" 							) ");
			query.append(" VALUES					( ");
			query.append(" 							'CN-' || TO_CHAR(SYSDATE, 'YYYYMMDDHH24') || '-' "
					+ "|| LPAD(CNTRY_ID_SEQ.NEXTVAL, 6, '0') ");
			query.append(" 							, ? ");
			query.append(" 							) ");

			stmt = conn.prepareStatement(query.toString());
			stmt.setString(1, countryVO.getCountryName());

			return stmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
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
	public int deleteCountry(String countryId) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage(), e);
		}

		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = DriverManager.getConnection(oracleUrl, "SUL", "sul");

			StringBuffer query = new StringBuffer();
			query.append(" DELETE	 ");
			query.append(" FROM		CNTRY ");
			query.append(" WHERE	CNTRY_ID = ? ");

			stmt = conn.prepareStatement(query.toString());
			stmt.setString(1, countryId);

			return stmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
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
	public CountryVO selectOneCountry(String countryId) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage(), e);
		}

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection(oracleUrl, "SUL", "sul");

			StringBuffer query = new StringBuffer();
			query.append(" SELECT		CNTRY_ID ");
			query.append(" 				, CNTRY_NM ");
			query.append(" FROM			CNTRY ");
			query.append(" WHERE		CNTRY_ID = ? ");

			stmt = conn.prepareStatement(query.toString());
			stmt.setString(1, countryId);

			rs = stmt.executeQuery();

			CountryVO countryVO = null;
			if (rs.next()) {
				countryVO = new CountryVO();
				countryVO.setCountryId(rs.getString("CNTRY_ID"));
				countryVO.setCountryName(rs.getString("CNTRY_NM"));
			}

			return countryVO;

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
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

}
