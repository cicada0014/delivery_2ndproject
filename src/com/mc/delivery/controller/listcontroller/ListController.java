package com.mc.delivery.controller.listcontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mc.delivery.action.Action;
import com.mc.delivery.action.ActionFactory;
@WebServlet(urlPatterns="/list")
public class ListController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	String command= req.getParameter("command");
	System.out.println("컨트롤러에 입력된 커맨드 잘되나:"+ command);
	ActionFactory af= ActionFactory.getActionFactory();
	Action action =  af.getAction(command);
	if(action!=null){
		action.execute(req, resp);
	}
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		this.doGet(req, resp);
	
	}
}
