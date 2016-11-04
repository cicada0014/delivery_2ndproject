package com.mc.delivery.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ActionHelper {
	private static ActionHelper instance;
	private ActionHelper() {
		// TODO Auto-generated constructor stub
	}
	public static ActionHelper getActionHelper(){
		if(instance==null){
			instance = new ActionHelper();
		}
		return instance;
	}

	public void actionFoward(HttpServletRequest request,HttpServletResponse response, String viewPath){
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			System.out.println("포워딩 오류");
			e.printStackTrace();
		}
	}

}
