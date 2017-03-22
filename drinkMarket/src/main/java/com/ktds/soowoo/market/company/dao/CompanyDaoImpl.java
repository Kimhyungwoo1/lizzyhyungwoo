package com.ktds.soowoo.market.company.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ktds.soowoo.market.company.vo.CompanyVO;

public class CompanyDaoImpl implements CompanyDao {

	private String oracleUrl = "jdbc:oracle:thin:@localhost:1521:XE";

	@Override
	public int insertCompany(CompanyVO companyVO) {

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
			query.append(" INSERT	INTO	CMPNY	( ");
			query.append(" 							CMPNY_ID ");
			query.append(" 							, CMPNY_NM ");
			query.append(" 							, LCTN ");
			query.append(" 							) ");
			query.append(" VALUES					( ");
			query.append(" 							'CM-' || TO_CHAR(SYSDATE, 'YYYYMMDDHH24') || '-' "
					+ "|| LPAD(CMPNY_ID_SEQ.NEXTVAL, 6, '0') ");
			query.append(" 							, ? ");
			query.append(" 							, ? ");
			query.append(" 							) ");
			
			stmt = conn.prepareStatement(query.toString());
			stmt.setString(1, companyVO.getCompanyName());
			stmt.setString(2, companyVO.getLocation());
			
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
	public int deleteCompany(String companyId) {
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
			query.append(" FROM		CMPNY ");
			query.append(" WHERE	CMPNY_ID = ? ");
			
			stmt = conn.prepareStatement(query.toString());
			stmt.setString(1, companyId);
			
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

}
