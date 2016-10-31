package com.mc.delivery.jdbcutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBHelper {
	
	private final static String DB_URL="jdbc:mysql://70.12.109.97:3306/delivery_2ndproject";
	private final static String DB_ID ="root";
	private final static String DB_PW = "1234";
	
	public static void makeConnection(){
		Connection con = null;
		try {
			con=DriverManager.getConnection(DB_URL, DB_ID, DB_PW);
			System.out.println("커넥션 연결 성공");
		} catch (SQLException e) {
			System.out.println("커넥션 생성 오류");
			e.printStackTrace();
		}
		
	}

	public static void close(Statement stmt){
			try {
				stmt.close();
			} catch (SQLException e) {
				System.out.println("스테이트먼트 종료실패");
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public static void close(ResultSet rs){
		try {
			rs.close();
		} catch (SQLException e) {
			System.out.println("resultset 종료실패");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void close(Connection con){
		try {
			con.close();
		} catch (SQLException e) {
			System.out.println("connection 종료실패");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void close(PreparedStatement pstmt){
		try {
			pstmt.close();
		} catch (SQLException e) {
			System.out.println("preparedStatement 종료실패");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
