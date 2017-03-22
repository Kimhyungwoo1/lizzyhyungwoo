package com.ktds.soowoo.market.type.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ktds.soowoo.market.type.vo.TypeVO;

public class TypeDaoImpl implements TypeDao {

	private String oracleUrl = "jdbc:oracle:thin:@localhost:1521:XE";

	@Override
	public int insertType(TypeVO typeVO) {

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
			query.append(" INSERT	INTO	TP	( ");
			query.append(" 							TP_ID ");
			query.append(" 							, TP_NM ");
			query.append(" 							) ");
			query.append(" VALUES					( ");
			query.append(" 							'TP-' || TO_CHAR(SYSDATE, 'YYYYMMDDHH24') || '-' "
					+ "|| LPAD(TP_ID_SEQ.NEXTVAL, 6, '0') ");
			query.append(" 							, ? ");
			query.append(" 							) ");

			stmt = conn.prepareStatement(query.toString());
			stmt.setString(1, typeVO.getTypeName());

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
	public int deleteType(String typeId) {

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
			query.append(" DELETE ");
			query.append(" FROM		TP ");
			query.append(" WHERE	TP_ID = ? ");

			stmt = conn.prepareStatement(query.toString());
			stmt.setString(1, typeId);

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
	public List<TypeVO> getAllTypeList() {

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
			query.append(" SELECT	TP_ID ");
			query.append(" 			, TP_NM ");
			query.append(" FROM		TP ");
			query.append(" ORDER	BY TP_ID DESC ");
			
			stmt = conn.prepareStatement(query.toString());
			
			rs = stmt.executeQuery();
			
			TypeVO typeVO = null;
			List<TypeVO> typeList = new ArrayList<TypeVO>();
			while( rs.next() ) {
				typeVO = new TypeVO();
				typeVO.setTypeId(rs.getString("TP_ID"));
				typeVO.setTypeName(rs.getString("TP_NM"));
				
				typeList.add(typeVO);
			}
			return typeList;
			
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

}
