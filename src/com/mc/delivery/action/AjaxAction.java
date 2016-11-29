package com.mc.delivery.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.mc.delivery.dao.RestaurantDAO;
import com.mc.delivery.vo.CategoryVO;
import com.mc.delivery.vo.RestaurantVO;

public class AjaxAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/xml;charset=UTF-8");
		Gson gson = new Gson();
		ServletContext sc = request.getServletContext();
	 	sc.getAttribute("restaurantDAO");
	 	RestaurantDAO dao = (RestaurantDAO) sc.getAttribute("restaurantDAO");
	 	String option= request.getParameter("option");
		int count= Integer.parseInt(request.getParameter("count"));
	 	
		List<RestaurantVO> voList= null;
		String restaurantList = null;
		List<CategoryVO> categoryList = (List<CategoryVO>)request.getSession().getAttribute("categoryListData");
		for(CategoryVO ct : categoryList){
			if(option.equals(ct.getCategoryName())){
				voList = dao.selectAjaxOption(option, count);
				restaurantList = gson.toJson(voList);
				break;
			}
			
		}
		System.out.println(restaurantList);
		response.getWriter().write(restaurantList);
	}

}
