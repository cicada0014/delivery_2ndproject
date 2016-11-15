package com.mc.delivery.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mc.delivery.jdbcutil.DBHelper;
import com.mc.delivery.vo.MenuScoreVO;

public class MenuScoreDAO {
	private DataSource dataSource;
	public void setDataSource(DataSource dataSource)
	{
		this.dataSource = dataSource;
	}
	
	private static MenuScoreDAO instance;
	public static MenuScoreDAO getInstance()
	{
		return instance;
	}
	
	public MenuScoreDAO(){}
	
	public int insertMenuScore(MenuScoreVO vo)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = "";
		
		try {
		conn = dataSource.getConnection();
		pstmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			System.out.println("코멘트 작성 오류");
			e.printStackTrace();
		} finally {
			DBHelper.close(pstmt);
			DBHelper.close(conn);
		}
		return result;
	}
}
