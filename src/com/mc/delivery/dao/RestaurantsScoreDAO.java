package com.mc.delivery.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.mc.delivery.jdbcutil.DBHelper;
import com.mc.delivery.vo.RestaurantsScoreVO;

public class RestaurantsScoreDAO {
	private DataSource dataSource;
	public void setDataSource(DataSource dataSource)
	{
		this.dataSource = dataSource;
	}
	
	private static RestaurantsScoreDAO instance;
	public static RestaurantsScoreDAO getInstance()
	{
		return instance;
	}
	
	public static RestaurantsScoreDAO getMenuScoreDAO()
	{
		if(instance == null)
		{
			instance = new RestaurantsScoreDAO();
		}
		return instance;
	}
	
	public RestaurantsScoreDAO(){}
	
	public int insertRestaurantScore(RestaurantsScoreVO vo)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = "INSERT INTO RESTAURANTS_SCORE(restaurant_id,user_name,restaurant_comment,comment_imgPath) " + "VALUES(?,?,?,?)";
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getRestaurantId());
			pstmt.setString(2, vo.getUserName());
			pstmt.setString(3, vo.getRestaurantComment());
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
	
	public int updateRestaurantScore(RestaurantsScoreVO vo)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = "UPDATE RESTAURANTS_SCORE set restaurant_comment=?, comment_imgPath=? WHERE restaurant_id=? AND comment_id=?";
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getRestaurantComment());
			pstmt.setString(2, vo.getCommentImgPath());
			pstmt.setInt(3, vo.getRestaurantId());
			pstmt.setInt(4, vo.getCommentId());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("코멘트 수정 오류");
			e.printStackTrace();
		}
		
		return result;
	}
	
	public int deleteRestaurantScore(int commentId)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = "DELETE FROM RESTAURANTS_SCORE WHERE COMMENT_ID=?";
		
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
	
	public List<RestaurantsScoreVO> selectRestaurantScoreList(int restaurantId)
	{
		List<RestaurantsScoreVO> menuScoreList = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM RESTAURANTS_SCORE WHERE restaurant_id=?";
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, restaurantId);
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				RestaurantsScoreVO vo = new RestaurantsScoreVO();
				vo.setRestaurantId(rs.getInt(1));
				vo.setCommentId(rs.getInt(2));
				vo.setUserName(rs.getString(3));
				vo.setRestaurantComment(rs.getString(4));
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
