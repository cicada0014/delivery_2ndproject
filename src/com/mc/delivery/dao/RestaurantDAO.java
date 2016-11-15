package com.mc.delivery.dao;

import java.sql.Connection;import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.mc.delivery.jdbcutil.DBHelper;
import com.mc.delivery.vo.CategoryVO;
import com.mc.delivery.vo.RestaurantVO;

public class RestaurantDAO {
	private DataSource dataSource;
	
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	private static RestaurantDAO instance;
	private RestaurantDAO(){
		
	}
	public static RestaurantDAO getRestaurantDAO(){
		if(instance==null){
			instance=new RestaurantDAO();
		}
		return instance;
	}
	//�떛湲��넠�쑝濡� DAO 媛앹껜 �깮�꽦.
	//////////////////////// 
	// �떇�떦 媛앹껜 �뜲�씠�꽣踰좎씠�뒪�뿉 �꽔湲�.
	public int insertRestaurantInfo(RestaurantVO vo){
		 Connection con = null;
		 PreparedStatement pstmt =null;
		 int result =0;
		 String sql = "INSERT INTO restaurants(restaurant_name,restaurant_location,"
		 		+ "restaurant_category,restaurant_img) VALUES(?,"
		 		+ "(SELECT location_id FROM locations WHERE location_name=?)"
		 		+ ",(SELECT category_id FROM category WHERE category_name=?)"
		 		+ ",?)";
	
		try {
			con= dataSource.getConnection();
			pstmt=con.prepareStatement(sql);
			System.out.println(vo.getRestaurantName()+"dao쪽");
			pstmt.setString(1, vo.getRestaurantName());
			pstmt.setString(2, vo.getRestaurantLocation());
			pstmt.setString(3, vo.getRestaurantCategory());
			pstmt.setString(4, vo.getRestaurantImg());
			result= pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			System.out.println("�떇�떦 �젙蹂닿컪 �엯�젰�떆 �삤瑜�");
			e.printStackTrace();
		}finally{
			DBHelper.close(pstmt);
			DBHelper.close(con);
		}return result;
	
	
	}
	/////////////////移댄뀒怨좊━ 由ъ뒪�듃 遺덈윭�삤湲�
	public List<CategoryVO> selectCategoryList(){
		List<CategoryVO> categoryList = new ArrayList<>();
		 Connection con = null;
		 PreparedStatement pstmt =null;
		 ResultSet rs= null;
		 String sql= "SELECT category_name, category_img FROM category";
		 try {
			 con= dataSource.getConnection();
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				CategoryVO vo = new CategoryVO();
				vo.setCategoryName(rs.getString(1));
				vo.setCategoryImg(rs.getString(2));
				categoryList.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBHelper.close(rs);
			DBHelper.close(pstmt);
			DBHelper.close(con);
		}return categoryList;
		 
	}
	
	// �꽑�깮�븳 移댄뀒怨좊━�뿉 留욌뒗 �떇�떦 由ъ뒪�듃�뱾 媛��졇�삤湲�
	public List<RestaurantVO> selectOption(String option){
		List<RestaurantVO> voList = new ArrayList<>();
		 Connection con = null;
		 PreparedStatement pstmt =null;
		 ResultSet rs= null;
		 String sql="SELECT a.restaurant_name,a.location_name,a.restaurant_img,"
		 		+ "a.restaurant_phone, a.restaurant_open_time, a.restaurant_close_time,"
		 		+ "a.restaurant_introduce FROM "
				 +"(SELECT * FROM restaurants as r LEFT JOIN locations as l "
				 + "ON r.restaurant_location=l.location_id "
				 +"WHERE restaurant_category= "
				 + "(SELECT category_id FROM category WHERE category_name=?))AS a;";
		 
		 
		 try {
			 con= dataSource.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, option);
			rs=pstmt.executeQuery();
			while(rs.next()){
				RestaurantVO vo = new RestaurantVO();
				vo.setRestaurantName(rs.getString(1));
				vo.setRestaurantLocation(rs.getString(2));
				vo.setRestaurantImg(rs.getString(3));
				vo.setRestaurnatPhone(rs.getString(4));
				vo.setRestaurantOpenTime(rs.getString(5));
				vo.setRestaurantCloseTime(rs.getString(6));
				vo.setRestaurantIntro(rs.getString(7));
				voList.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBHelper.close(rs);
			DBHelper.close(pstmt);

			DBHelper.close(con); // 데이타 소스를 이용한 커넥션연결에서 클로즈란 완전히 끊는 것이 아닌
//			커넥션 대행객체를 ㄲ주는 거임. 대행객체가 닫힐때는 커넥션풀에 진짜 커넥션 객체를 반납한다고이해해야함.

		}return voList;
		 
	}
	
}
