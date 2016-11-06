package com.mc.delivery.action.restaurantaction;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mc.delivery.action.Action;
import com.mc.delivery.action.ActionHelper;
import com.mc.delivery.dao.RestaurantDAO;
import com.mc.delivery.vo.RestaurantVO;

public class TakeListAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//리퀘스트객체에서 추가 파라미터를 가져와서 어떤 카테고로인지 판단한다.
				String viewPath="mainList.jsp";
				RestaurantDAO dao = RestaurantDAO.getRestaurantDAO();
				String option= request.getParameter("option");
				List<RestaurantVO> voList= null;
				if(option.equals("pizza")){
					voList = dao.selectOption(option);
					request.setAttribute("restaurantList", voList);
					request.setAttribute("category", voList.get(0).getRestaurantCategory()); 
				}else if(option.equals("chicken")){
					voList = dao.selectOption(option);
					request.setAttribute("restaurantList", voList);
					request.setAttribute("category", voList.get(0).getRestaurantCategory());
				}
			ActionHelper.getActionHelper().actionFoward(request, response, viewPath);
		
	}

}
