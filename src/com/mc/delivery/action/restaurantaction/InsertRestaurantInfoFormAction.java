package com.mc.delivery.action.restaurantaction;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mc.delivery.action.Action;
import com.mc.delivery.action.ActionHelper;
import com.mc.delivery.dao.RestaurantDAO;
import com.mc.delivery.vo.CategoryVO;

public class InsertRestaurantInfoFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// connection pool 로 생성된 다오 객체 가져오기
		ServletContext sc = request.getServletContext();
		RestaurantDAO dao = (RestaurantDAO) sc.getAttribute("restaurantDAO");
		
		List<CategoryVO>  categoryList = dao.selectCategoryList();
		List<String> locationList = dao.selectLocationList();
		request.setAttribute("categoryList", categoryList);
		request.setAttribute("locationList", locationList);
		
		
		String viewPath="insertRestaurant.jsp";
		ActionHelper.getActionHelper().actionFoward(request, response, viewPath);
	}

}
