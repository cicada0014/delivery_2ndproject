package com.mc.delivery.action.restaurantaction;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mc.delivery.action.Action;
import com.mc.delivery.action.ActionHelper;
import com.mc.delivery.dao.RestaurantDAO;
import com.mc.delivery.vo.RestaurantVO;
import com.oreilly.servlet.MultipartRequest;

public class InsertRestaurantAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		MultipartRequest multi = (MultipartRequest) request.getAttribute("multi");
		
		//데이터 베이스에는 파일명만 기입하도록 한다. 이미지는 나중에 뷰에서 처리해서 보내준다. 
		 String restaurantName = multi.getParameter("restaurantName");
		 String restaurantLocation = multi.getParameter("restaurantLocation");
		 String restaurantCategory = multi.getParameter("restaurantCategory");
		 
		 String restaurantImgFileName = "default_img.png" ;
			if(multi.getFilesystemName("restaurantImgFile")==null||multi.getFilesystemName("restaurantImgFile").equals("")){
				
			}else{
				restaurantImgFileName = multi.getFilesystemName("restaurantImgFile");
			}
		// 객체에 정보 담기.  
		 RestaurantVO vo = new RestaurantVO();
		 vo.setRestaurantName(restaurantName);
		 vo.setRestaurantLocation(restaurantLocation);
		 vo.setRestaurantCategory(restaurantCategory);
		 vo.setRestaurantImg(restaurantImgFileName);
		 RestaurantDAO dao = RestaurantDAO.getRestaurantDAO();
		 int result= dao.insertRestaurantInfo(vo);
		 request.setAttribute("result", result);
		 String viewPath = "result.jsp";
		 ActionHelper.getActionHelper().actionFoward(request, response, viewPath);
		
	}

}
