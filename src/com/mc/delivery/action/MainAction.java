package com.mc.delivery.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String viewPath = "index.jsp";
		
		
		
		
		ActionHelper.getActionHelper().actionFoward(request, response, viewPath);
	}

}
