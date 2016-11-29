package com.mc.delivery.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	
	public static MenuScoreDAO getMenuScoreDAO()
	{
		if(instance == null)
		{
			instance = new MenuScoreDAO();
		}
		return instance;
	}
	
	public MenuScoreDAO(){}
	
	public int insertMenuScore(MenuScoreVO vo)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = "INSERT INTO MENU_SCORE(menu_id,user_name,menu_comment,comment_imgPath) " + "VALUES(?,?,?,?)";
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getMenuId());
			pstmt.setString(2, vo.getUserName());
			pstmt.setString(3, vo.getMenuComment());
			pstmt.setString(4, vo.getCommentImgPath());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("코멘트 작성 오류");
			e.printStackTrace();
		} finally {
			DBHelper.close(pstmt);
			DBHelper.close(conn);
		}
		return result;
	}
	
	public int updateMenuScore(MenuScoreVO vo)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = "UPDATE MENU_SCORE set menu_comment=?, comment_imgPath=? WHERE menu_id=? AND comment_id=?";
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getMenuComment());
			pstmt.setString(2, vo.getCommentImgPath());
			pstmt.setInt(3, vo.getMenuId());
			pstmt.setInt(4, vo.getCommentId());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("코멘트 수정 오류");
			e.printStackTrace();
		}
		
		return result;
	}
	
	public int deleteMenuScore(int commentId)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = "DELETE FROM MENU_SCORE WHERE COMMENT_ID=?";
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, commentId);
			
			result = pstmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("코멘트 삭제 오류");
			e.printStackTrace();
		} finally {
			DBHelper.close(pstmt);
			DBHelper.close(conn);
		}
		return result;
	}
	
	public List<MenuScoreVO> selectMenuScoreList(int restaurantId)
	{
		List<MenuScoreVO> menuScoreList = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT user_name,menu_comment,comment_imgPath FROM menu_score WHERE menu_id=?";
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, restaurantId);
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				MenuScoreVO vo = new MenuScoreVO();
				vo.setMenuId(rs.getInt(1));
				vo.setCommentId(rs.getInt(2));
				vo.setUserName(rs.getString(3));
				vo.setMenuComment(rs.getString(4));
				vo.setCommentImgPath(rs.getString(5));
				
				menuScoreList.add(vo);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBHelper.close(rs);
			DBHelper.close(pstmt);
			DBHelper.close(conn);
		}
		return menuScoreList;
	}
}
