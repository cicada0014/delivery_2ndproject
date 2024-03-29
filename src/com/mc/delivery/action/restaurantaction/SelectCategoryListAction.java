package com.mc.delivery.action.restaurantaction;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mc.delivery.action.Action;
import com.mc.delivery.action.ActionHelper;
import com.mc.delivery.dao.RestaurantDAO;
import com.mc.delivery.vo.CategoryVO;

public class SelectCategoryListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
          List<CategoryVO> categoryList=RestaurantDAO.getRestaurantDAO().selectCategoryList();
          String categoryListLength = categoryList.size()+"";
          request.setAttribute("categoryList", categoryList);
          request.setAttribute("categoryListSize", categoryListLength);
          String viewPath= "categoryList.jsp";
          ActionHelper.getActionHelper().actionFoward(request, response, viewPath);
          
		//fdsfdf
	}

}
