package com.ktds.soowoo.market.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ktds.soowoo.market.user.vo.UserVO;

public class UserDaoImpl implements UserDao {

	private String oracleUrl = "jdbc:oracle:thin:@localhost:1521:XE";

	@Override
	public int insertUser(UserVO userVO) {

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
			query.append(" INSERT	INTO	USR	( ");
			query.append(" 							USR_ID ");
			query.append(" 							, USR_NM ");
			query.append(" 							, USR_PWD ");
			query.append(" 							, PNT ");
			query.append(" 							) ");
			query.append(" VALUES					( ");
			query.append(" 							'US-' || TO_CHAR(SYSDATE, 'YYYYMMDDHH24') || '-' "
					+ "|| LPAD(USR_ID_SEQ.NEXTVAL, 6, '0') ");
			query.append(" 							, ? ");
			query.append(" 							, ? ");
			query.append(" 							, 500 ");
			query.append(" 							) ");

			stmt = conn.prepareStatement(query.toString());
			stmt.setString(1, userVO.getUserName());
			stmt.setString(2, userVO.getUserPassword());

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
	public UserVO selectUser(UserVO userVO) {

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
			query.append(" SELECT	USR_ID ");
			query.append(" 			, USR_NM ");
			query.append(" 			, USR_PWD ");
			query.append(" 			, PNT ");
			query.append(" FROM		USR ");
			query.append(" WHERE	USR_ID = ? ");
			query.append(" AND		USR_PWD = ? ");

			stmt = conn.prepareStatement(query.toString());
			stmt.setString(1, userVO.getUserId());
			stmt.setString(2, userVO.getUserPassword());

			rs = stmt.executeQuery();

			if (rs.next()) {
				userVO.setUserId(rs.getString("USR_ID"));
				userVO.setUserName(rs.getString("USR_NM"));
				userVO.setUserPassword(rs.getString("USR_PWD"));
				userVO.setPoint(rs.getInt("PNT"));

			}

			return userVO;

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
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
	public int updatePoint(String userId, int point) {
		
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
			query.append(" UPDATE	USR ");
			query.append(" SET		PNT = PNT + ? ");
			query.append(" WHERE	USR_IN = ? ");

			stmt = conn.prepareStatement(query.toString());
			stmt.setInt(1, point);
			stmt.setString(2, userId);

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
