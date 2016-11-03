package com.mc.delivery.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mc.delivery.jdbcutil.DBHelper;
import com.mc.delivery.vo.RestaurantVO;

public class RestaurantDAO {
	
	private static RestaurantDAO instance;
	private RestaurantDAO(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 생성 오류");
			e.printStackTrace();
		}
	}
	public static RestaurantDAO getRestaurantDAO(){
		if(instance==null){
			instance=new RestaurantDAO();
		}
		return instance;
	}
	
	
	public int insertRestaurantInfo(RestaurantVO vo){
		 Connection con = DBHelper.makeConnection();
		 PreparedStatement pstmt =null;
		 int result =0;
		 String sql = "INSERT INTO restaurants(restaurant_name,restaurant_location,"
		 		+ "restaurant_category) VALUES(?,"
		 		+ "(SELECT location_id FROM locations WHERE location_name=?)"
		 		+ ",(SELECT category_id FROM category WHERE category_name=?))";
	
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, vo.getRestaurantName());
			pstmt.setString(2, vo.getRestaurantLocation());
			pstmt.setString(3, vo.getRestaurantCategory());
			result= pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			System.out.println("식당 정보값 입력시 오류");
			e.printStackTrace();
		}finally{
			DBHelper.close(pstmt);
			DBHelper.close(con);
		}return result;
	
	
	}
	
	
	
}
