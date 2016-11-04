package com.mc.delivery.action.restaurantaction;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mc.delivery.action.Action;
import com.mc.delivery.action.ActionHelper;

public class CategoryOptionAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//리퀘스트객체에서 추가 파라미터를 가져와서 어떤 카테고로인지 판단한다.
		String viewPath="";
		String option= request.getParameter("option");
		if(option.equals("pizza")){
			viewPath="pizzaCategory.jsp";
		}else if(option.equals("chicken")){
			viewPath="chickenCategory.jsp";
		}
		
		ActionHelper.getActionHelper().actionFoward(request, response, viewPath);
	}

}
