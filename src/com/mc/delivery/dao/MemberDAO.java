package com.mc.delivery.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mc.delivery.jdbcutil.DBHelper;
import com.mc.delivery.vo.MemberVO;

public class MemberDAO {
	private static MemberDAO instance;
	
private DataSource dataSource;
	
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	private MemberDAO() {

	}

	public static MemberDAO getMemberDAO() {
		if (instance == null) {
			instance = new MemberDAO();
		}
		return instance;
	}

	// 사용자 인증 패스워드 일치확인
	public int userCheck(String email, String pwd) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;

		try {
			con = dataSource.getConnection();
			String sql = "SELECT PASSWORD FROM MEMBER WHERE EMAIL=?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				if (rs.getString(1) != null && rs.getString(1).equals(pwd)) {
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
			DBHelper.close(con);
		}

		System.out.println(result);
		//
		System.out.println("pwd : " + pwd);
		//
		return result;
	}

	// 회원한명 정보보기
	public MemberVO getMember(String email) {
		MemberVO mvo = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = dataSource.getConnection();
			String sql = "select * from member where email=?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				mvo = new MemberVO();
				mvo.setEmail(rs.getString(1));
				mvo.setName(rs.getString(2));
				mvo.setPwd(rs.getString(3));
				mvo.setPhone(rs.getString(4));
				mvo.setBrithday(rs.getString(5));
				mvo.setPoint(rs.getInt(7));
			}

		} catch (SQLException e) {
			System.out.println("회원정보셀렠 커넥오류");
			e.printStackTrace();
		} finally {
			DBHelper.close(rs);
			DBHelper.close(pstmt);
			DBHelper.close(con);
		}

		System.out.println(mvo);
		return mvo;
	}

	// 아이디중복체크 메소드
	public int confirmEmail(String email) {
		MemberVO mvo = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = -1;

		try {
			con = dataSource.getConnection();
			String sql = "SELECT EMAIL FROM MEMBER WHERE EMAIL=?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = 1;
			} else {
				result = -1;
			}
		} catch (SQLException e) {
			System.out.println("이메일체크 커넥션 오류");
			e.printStackTrace();
		} finally {
			DBHelper.close(rs);
			DBHelper.close(pstmt);
			DBHelper.close(con);
		}

		System.out.println(result);

		return result;

	}

	// 인설트
	public int insertMember(MemberVO mvo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = -1;

		try {
			con = dataSource.getConnection();
			String sql =

					"INSERT INTO MEMBER (EMAIL,NAME,PASSWORD,PHONE,BRITHDAY) VALUES(?,?,?,?,?)";
			// "INSERT INTO MEMBER (USERID,EMAIL,NAME,PASSWORD,PHONE,BRITHDAY)
			// VALUES(?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mvo.getEmail());
			pstmt.setString(2, mvo.getName());
			pstmt.setString(3, mvo.getPwd());
			pstmt.setString(4, mvo.getPhone());
			pstmt.setString(5, mvo.getBrithday());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("인서트 커넥션 에러");
			e.printStackTrace();
		} finally {
			DBHelper.close(pstmt);
			DBHelper.close(con);

		}

		System.out.println(result);
		return result;
	}

	// 정보수정
	public int updateMember(MemberVO mvo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = -1;

		try {
			con = dataSource.getConnection();
			String sql = "UPDATE MEMBER SET " + "NAME=? , PASSWORD=? , PHONE=? , BRITHDAY=? WHERE EMAIL=?";

			// "UPDATE MEMBER SET EMAIL=? , NAME=? , PASSWORD=? , PHONE=? ,
			// BRITHDAY=? WHERE USERID=?";

			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, mvo.getName());
			pstmt.setString(2, mvo.getPwd());
			pstmt.setString(3, mvo.getPhone());
			pstmt.setString(4, mvo.getBrithday());
			pstmt.setString(5, mvo.getEmail());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("업데이트 커넥션 에러");
			e.printStackTrace();
		} finally {
			DBHelper.close(con);
			DBHelper.close(pstmt);

		}
		System.out.println(result);
		return result;

	}

	// 사용자 인증 패스워드 일치확인
	public int n_userCheck(String email) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;

		try {
			con = dataSource.getConnection();
			String sql = "SELECT EMAIL FROM MEMBER WHERE EMAIL=?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				if (rs.getString(1) != null && rs.getString(1).equals(email)) {
					result = 1;
				} else {
					result = 0;
				}

			} else {
				result = -1;
			}

		} catch (SQLException e) {
			System.out.println("네이버 유저쳌커넥션 에러");
			e.printStackTrace();
		} finally {
			DBHelper.close(rs);
			DBHelper.close(pstmt);
			DBHelper.close(con);
		}
		System.out.println("비밀번호 체크 잘됨");
		System.out.println(result);
		return result;
	}

	// 물건살때 가격의 10퍼센트 포인트 적립
	public int plusPoint(int point, String email) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = -1;

		try {
			con = dataSource.getConnection();
			String sql = "UPDATE MEMBER SET POINT = POINT+? WHERE EMAIL=?";

			// "UPDATE MEMBER SET EMAIL=? , NAME=? , PASSWORD=? , PHONE=? ,
			// BRITHDAY=? WHERE USERID=?";

			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, point);
			pstmt.setString(2, email);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("플러스포인트 커넥션 에러");
			e.printStackTrace();
		} finally {
			DBHelper.close(con);
			DBHelper.close(pstmt);

		}
		System.out.println(result);
		return result;

	}

	// 포인트로 물건살때 가격가격만큼 차감
	public int minusPoint(int point, String email) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = -1;

		try {
			con = dataSource.getConnection();
			String sql = "UPDATE MEMBER SET POINT = POINT-? WHERE EMAIL=?";

			// "UPDATE MEMBER SET EMAIL=? , NAME=? , PASSWORD=? , PHONE=? ,
			// BRITHDAY=? WHERE USERID=?";

			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, point);
			pstmt.setString(2, email);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("마이너스포인트 커넥션 에러");
			e.printStackTrace();
		} finally {
			DBHelper.close(con);
			DBHelper.close(pstmt);

		}
		System.out.println(result);
		return result;

	}

}
