package com.mc.delivery.controller.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mc.delivery.dao.MemberDAO;
import com.mc.delivery.vo.MemberVO;


@WebServlet("/member.do")
public class memberController extends HttpServlet  {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		execute(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		execute(req, resp);
	}
	
	
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		String viewPath = "";
		
		if(  action.equals("join")){
			viewPath = "join_form.jsp";
		} else if (action.equals("join_get")){
			String userid = request.getParameter("userid");
			String email = request.getParameter("email");
			String name = request.getParameter("name");
			String pwd = request.getParameter("pwd");
			String phone = request.getParameter("phone");
			String brithday = request.getParameter("brithday");
			String adminStr = request.getParameter("admin");
			int admin = 0;
			if(adminStr != null && adminStr.length() > 0 ){
				admin = Integer.parseInt(adminStr);
			}
			
			MemberVO mvo = new MemberVO();
			mvo.setUserid(userid);
			mvo.setEmail(email);
			mvo.setName(name);
			mvo.setPwd(pwd);
			mvo.setPhone(phone);
			mvo.setBrithday(brithday);
			mvo.setAdmin(admin);
		
			MemberDAO dao = MemberDAO.getMemberDAO();
			
			int result = dao.insertMember(mvo);
			
//			HttpSession session = request.getSession();
			
			if(result == 1){
//				session.setAttribute("userid", mvo.getUserid());
//				session.setAttribute("admin", mvo.getAdmin());
				request.setAttribute("userid", mvo.getUserid());
				
			} 
			viewPath = "join_result.jsp";
			
		} else if (action.equals("idcheck")){	
		
		String userid = request.getParameter("userid");
		viewPath = "idcheck.jsp";
		MemberDAO dao = MemberDAO.getMemberDAO();
		
		int result = dao.confirmID(userid);
		
		request.setAttribute("userid", userid);
		request.setAttribute("result", result);
		
		
		} else if(action.equals("main")){
			viewPath = "index.jsp";
		} else if (action.equals("logout")){
			HttpSession session = request.getSession();
			session.invalidate();
			viewPath="index.jsp";
		} else if(action.equals("login")){
			viewPath="login_form.jsp";
		} else if(action.equals("login_check")){
			
			String userid = request.getParameter("userid");
			String pwd = request.getParameter("pwd");
			
			MemberDAO dao = MemberDAO.getMemberDAO();
			int result= dao.userCheck(userid, pwd);
			
			if(result == 1){
				MemberVO mvo = dao.getMember(userid);
				HttpSession session = request.getSession();
				
				session.setAttribute("userid", mvo.getUserid());
				session.setAttribute("admin", mvo.getAdmin());
				
				viewPath = "index.jsp";
			} else {
				request.setAttribute("result", result);
				viewPath = "login_result.jsp";
			}
						
		} else if (action.equals("update")){
			String userid = request.getParameter("userid");
			MemberDAO dao = MemberDAO.getMemberDAO();
			
			MemberVO mvo  = dao.getMember(userid);
			
			request.setAttribute("mvo", mvo);
					
			viewPath = "update_form.jsp";
			
		} else if(action.equals("update_get")){
			
			String name = request.getParameter("name");
			String userid = request.getParameter("userid");
			String pwd = request.getParameter("pwd");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			String brithday = request.getParameter("brithday");
			
			MemberVO mvo = new MemberVO();
			mvo.setName(name);
			mvo.setUserid(userid);
			mvo.setPwd(pwd);
			mvo.setEmail(email);
			mvo.setPhone(phone);
			mvo.setBrithday(brithday);
			
		//	System.out.println(mvo);
			MemberDAO dao = MemberDAO.getMemberDAO();
			
			int result = dao.updateMember(mvo);
			
			if(result == 1){
				request.setAttribute("mvo", mvo);
				viewPath="update_result.jsp";
			}
			
						
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
		dispatcher.forward(request, response);
		
	}
	
}

