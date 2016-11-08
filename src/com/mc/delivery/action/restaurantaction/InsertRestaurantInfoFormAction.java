package com.mc.delivery.action.restaurantaction;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mc.delivery.action.Action;
import com.mc.delivery.action.ActionHelper;

public class InsertRestaurantInfoFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String viewPath="insertRestaurant.jsp";
		ActionHelper.getActionHelper().actionFoward(request, response, viewPath);
	}

}
