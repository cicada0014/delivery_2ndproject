package com.mc.delivery.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.mc.delivery.jdbcutil.DBHelper;
import com.mc.delivery.vo.MenuVO;

public class MenuDAO {
	private DataSource dataSource;
	public void setDataSource(DataSource dataSource)
	{
		this.dataSource = dataSource;
	}
	
	private static MenuDAO instance;
	public static MenuDAO getInstance()
	{
		return instance;
	}
	
	public MenuDAO(){}
	
	//메뉴 입력
	public int insertMenuInfo(MenuVO vo)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = "INSERT INTO RESTAURANTS_MENU(restaurant_id,menu_category,menu_name,menu_info,menu_price,menu_score,menu_imagePath) "
				+ "VALUES(?,?,?,?,?,?,?)";
		
		try {
//			conn = new DBHelper().makeConnection();
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getRestaurantId());
			pstmt.setString(2, vo.getMenuCategory());
			pstmt.setString(3, vo.getMenuName());
			pstmt.setString(4, vo.getMenuInfo());
			pstmt.setInt(5, vo.getMenuPrice());
			pstmt.setInt(6, vo.getMenuScore());
			pstmt.setString(7, vo.getMenuImagePath());
			
			result = pstmt.executeUpdate(); 
			
		} catch (SQLException e) {
			System.out.println("메뉴 정보 입력 오류");
			e.printStackTrace();
		} finally {
			DBHelper.close(pstmt);
			DBHelper.close(conn);
		}
		
		return result;
	}
	
	//메뉴 리스트 가져오기
	public List<MenuVO> selectMenuList(String restaurantId)
	{
		List<MenuVO> menuList = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT menu_name,menu_info,menu_price,menu_score,menu_imagePath FROM restaurants_menu WHERE restaurant_id=?";
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, restaurantId);
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				MenuVO vo = new MenuVO();
				vo.setMenuName(rs.getString(1));
				vo.setMenuInfo(rs.getString(2));
				vo.setMenuPrice(rs.getInt(3));
				vo.setMenuScore(rs.getInt(4));
				vo.setMenuImagePath(rs.getString(5));
				
				menuList.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBHelper.close(rs);
			DBHelper.close(pstmt);
			DBHelper.close(conn);
		}
		return menuList;
	}
}
