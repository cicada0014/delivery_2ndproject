package com.mc.delivery.jdbcutil;

import java.sql.Connection;import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBHelper {
	//////// 而ㅻ꽖�뀡 �� 媛쒕뀗 �룄�엯!
	
//	private final String DB_URL="jdbc:mysql://localhost:3306/delivery_2ndproject";
	private final String DB_URL="jdbc:mysql://70.12.109.97:3306/delivery_2ndproject";
	private final String DB_ID ="root";
	private final String DB_PW = "1234";
//	private final String DB_PW = "1q2w3e4r";
	
	private ArrayList<Connection> connList = new ArrayList<>();
	
	
	
	public DBHelper(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("�뱶�씪�씠踰� �깮�꽦 �삤瑜�");
			e.printStackTrace();
		}
	}
	
	
	
//	// 而ㅻ꽖�뀡 �� 媛쒕뀗�쓣 �룄�엯�븿. 理쒕�媛쒖닔�뒗 �젣�븳 �븯吏� �븡�쓬.  context.xml�뿉�꽌 議곗옉�븯�뿬 �븘�슂 �뾾�뼱吏�
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
				System.out.println("而ㅻ꽖�뀡 �뿰寃� �꽦怨�");
			} catch (SQLException e) {
				System.out.println("而ㅻ꽖�뀡 �깮�꽦 �삤瑜�");
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
				System.out.println("�뒪�뀒�씠�듃癒쇳듃 醫낅즺�떎�뙣");
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public static void close(ResultSet rs){
		try {
			if(rs!=null)
			rs.close();
		} catch (SQLException e) {
			System.out.println("resultset 醫낅즺�떎�뙣");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static  void closeAllCon(Connection con){
		try {
			if(con!=null)
				con.close();
			
		} catch (SQLException e) {
			System.out.println("connection 醫낅즺�떎�뙣");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void close(PreparedStatement pstmt){
		try {
			if(pstmt!=null)
			pstmt.close();
		} catch (SQLException e) {
			System.out.println("preparedStatement 醫낅즺�떎�뙣");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
