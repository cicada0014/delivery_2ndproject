package com.mc.delivery.restaurantaction;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mc.delivery.action.Action;
import com.mc.delivery.action.ActionHelper;
import com.mc.delivery.dao.RestaurantDAO;
import com.mc.delivery.vo.RestaurantVO;

public class InsertRestaurantAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String restaurantName = request.getParameter("restaurantName");
		 String restaurantLocation = request.getParameter("restaurantLocation");
		 String restaurantCategory = request.getParameter("restaurantCategory");
		 
		 RestaurantVO vo = new RestaurantVO();
		 vo.setRestaurantName(restaurantName);
		 vo.setRestaurantLocation(restaurantLocation);
		 vo.setRestaurantCategory(restaurantCategory);
		 
		 RestaurantDAO dao = RestaurantDAO.getRestaurantDAO();
		 int result= dao.insertRestaurantInfo(vo);
		 request.setAttribute("result", result);
		 String viewPath = "result.jsp";
		 ActionHelper.getActionHelper().actionFoward(request, response, viewPath);
		
	}

}
