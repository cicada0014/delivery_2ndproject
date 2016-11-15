package com.mc.delivery.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.plaf.synth.SynthSeparatorUI;

import com.mc.delivery.jdbcutil.DBHelper;
import com.mc.delivery.vo.MemberVO;

public class MemberDAO {
	private static MemberDAO instance;
	private MemberDAO(){
		
	}
	public static MemberDAO getMemberDAO(){
		if(instance==null){
			instance=new MemberDAO();
		}
		return instance;
	}

	//사용자 인증 패스워드 일치확인
		public int userCheck(String userid, String pwd) {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			int result = 0;

			try {
				con = new DBHelper().makeConnection();
				String sql ="SELECT PASSWORD FROM MEMBER WHERE USERID=?"; 
				

				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, userid);
				rs = pstmt.executeQuery();
			
				if(rs.next()){
					if(rs.getString(1) != null &&  rs.getString(1).equals(pwd)){
						result = 1;
					} else {
						result = 0;
					}
					
				} else {
					result = -1;
				}
						
				
			} catch (SQLException e) {
				System.out.println("유저쳌커넥션 에러");
				e.printStackTrace();
			} finally {
				DBHelper.close(rs);
				DBHelper.close(pstmt);
				DBHelper.closeAllCon(con);
			}
			System.out.println("비밀번호 체크 잘됨");
			System.out.println(result);
			return result;
		}
		//회원한명 정보보기
		public MemberVO getMember(String userid){
			MemberVO mvo = null;
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
			con = new DBHelper().makeConnection();
			String sql ="select * from member where userid=?"; 
			
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,userid);
				rs = pstmt.executeQuery();
				if(rs.next()){
					mvo = new MemberVO();
					mvo.setUserid(rs.getString(1));
					mvo.setEmail(rs.getString(2));
					mvo.setName(rs.getString(3));
					mvo.setPwd(rs.getString(4));
					mvo.setPhone(rs.getString(5));
					mvo.setBrithday(rs.getString(6));
				}

			} catch (SQLException e) {
				System.out.println("회원정보셀렠 커넥오류");
				e.printStackTrace();
			} finally {
				DBHelper.close(rs);
				DBHelper.close(pstmt);
				DBHelper.closeAllCon(con);
			}
			System.out.println("회원정보불러오그 잘됨");
			System.out.println(mvo);
			return mvo ;
		}
		
		//아이디중복체크 메소드
		public int confirmID(String userid){
			MemberVO mvo = null;
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			int result = -1;
			
			try {
			con = new DBHelper().makeConnection();
			String sql ="SELECT USERID FROM MEMBER WHERE USERID=?"; 
					
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, userid);
				rs = pstmt.executeQuery();
				if(rs.next()){
					result = 1;
				} else {
					result = -1;	
				} 
			} catch (SQLException e) {
				System.out.println("아이디체크 커넥션 오류");
				e.printStackTrace();
			} finally {
				DBHelper.close(rs);
				DBHelper.close(pstmt);
				DBHelper.closeAllCon(con);
			}
			System.out.println("중복체크 잘됨");
			System.out.println(result);

			return result ;

		}
		
		//인설트
		public int insertMember(MemberVO mvo){
			Connection con = null;
			PreparedStatement pstmt = null;
			int result = -1;
			
			try {
			con = new DBHelper().makeConnection();
			String sql =  
					"INSERT INTO MEMBER (USERID,EMAIL,NAME,PASSWORD,PHONE,BRITHDAY) VALUES(?,?,?,?,?,?)";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, mvo.getUserid());
				pstmt.setString(2, mvo.getEmail());
				pstmt.setString(3, mvo.getName());
				pstmt.setString(4, mvo.getPwd());
				pstmt.setString(5, mvo.getPhone());
				pstmt.setString(6, mvo.getBrithday());
				
				result = pstmt.executeUpdate();
				
			} catch (SQLException e) {
				System.out.println("인서트 커넥션 에러");
				e.printStackTrace();
			} finally {
				DBHelper.close(pstmt);
				DBHelper.closeAllCon(con);
			}
			System.out.println("인서트 잘됨");
			System.out.println(result);
			return result;	
		}

} 
