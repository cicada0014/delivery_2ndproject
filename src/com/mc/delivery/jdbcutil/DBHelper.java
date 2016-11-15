package com.mc.delivery.jdbcutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBHelper {
	//////// 커넥션 풀 개념 도입!
	
//	private final String DB_URL="jdbc:mysql://localhost:3306/delivery_2ndproject";
	private final String DB_URL="jdbc:mysql://70.12.109.97:3306/delivery_2ndproject";
	private final String DB_ID ="root";
	private final String DB_PW = "1234";
//	private final String DB_PW = "sds902";
	
	private ArrayList<Connection> connList = new ArrayList<>();
	
	
	
	public DBHelper(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 생성 오류");
			e.printStackTrace();
		}
	}
	
	
	
//	// 커넥션 풀 개념을 도입함. 최대개수는 제한 하지 않음.  context.xml에서 조작하여 필요 없어짐
	public  Connection makeConnection(){
		Connection con = null;
		
		if(connList.size()>0){
			for(int i=0; i<connList.size();i++){
				try {
					if((con=connList.get(i)).isValid(10)){
						break;
						
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
				
			}
			
		}else{
			try {
				con=DriverManager.getConnection(DB_URL, DB_ID, DB_PW);
				System.out.println("커넥션 연결 성공");
			} catch (SQLException e) {
				System.out.println("커넥션 생성 오류");
				e.printStackTrace();
			
		}
		}
		
		return con;
	}

//	public void returnConnection(Connection con){
//		connList.add(con);
//	}

	
	
	
	
	public static void close(Statement stmt){
			try {
				if(stmt!=null)
				stmt.close();
			} catch (SQLException e) {
				System.out.println("스테이트먼트 종료실패");
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public static void close(ResultSet rs){
		try {
			if(rs!=null)
			rs.close();
		} catch (SQLException e) {
			System.out.println("resultset 종료실패");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void close(Connection con){
		try {
			if(con!=null)
				con.close();
			
		} catch (SQLException e) {
			System.out.println("connection 종료실패");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void close(PreparedStatement pstmt){
		try {
			if(pstmt!=null)
			pstmt.close();
		} catch (SQLException e) {
			System.out.println("preparedStatement 종료실패");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
