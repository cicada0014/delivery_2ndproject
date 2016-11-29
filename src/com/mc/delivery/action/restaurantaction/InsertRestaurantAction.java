package com.mc.delivery.action.restaurantaction;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mc.delivery.action.Action;
import com.mc.delivery.action.ActionHelper;
import com.mc.delivery.dao.RestaurantDAO;
import com.mc.delivery.databinding.DataBinding;
import com.mc.delivery.vo.RestaurantVO;
import com.oreilly.servlet.MultipartRequest;

public class InsertRestaurantAction implements Action,DataBinding{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		MultipartRequest multi = (MultipartRequest) request.getAttribute("multi");
	
		//데이터 베이스에는 파일명만 기입하도록 한다. 이미지는 나중에 뷰에서 처리해서 보내준다. 
		 String restaurantName = multi.getParameter("restaurantName");
		 String restaurantLocation = multi.getParameter("restaurantLocation");
		 String restaurantCategory = multi.getParameter("restaurantCategory");
		 String restaurantPhone= multi.getParameter("restaurantPhone");
		 String restaurantOpenTime= multi.getParameter("restaurantOpenTime");
		 String restaurantCloseTime= multi.getParameter("restaurantCloseTime");
		 String restaurantIntroduce=multi.getParameter("restaurantIntroduce");
		 System.out.println(restaurantCategory);
		 String restaurantImgFileName = "default_img.png" ;
			if(multi.getFilesystemName("restaurantImgFile")==null||multi.getFilesystemName("restaurantImgFile").equals("")){
				
			}else{
				restaurantImgFileName = multi.getFilesystemName("restaurantImgFile");
			}
			
			System.out.println(restaurantImgFileName);
		// 객체에 정보 담기.  
		 RestaurantVO vo = new RestaurantVO();
		 vo.setRestaurantName(restaurantName);
		 vo.setRestaurantLocation(restaurantLocation);
		 vo.setRestaurantCategory(restaurantCategory);
		 vo.setRestaurantImg(restaurantImgFileName);
		 vo.setRestaurantIntro(restaurantIntroduce);
		 vo.setRestaurantCloseTime(restaurantCloseTime);
		 vo.setRestaurantOpenTime(restaurantOpenTime);
		 vo.setRestaurantPhone(restaurantPhone);
		 ServletContext sc = request.getServletContext();
		 RestaurantDAO dao = (RestaurantDAO) sc.getAttribute("restaurantDAO");
		 // 싱글톤으로 생성했는데 굳이 어플리케이션에 생성해주는 것도 웃기다. 오히려 코드가 더 늘어나는 기분임. 그냥 가져다 쓰면될텐데. 
//		 RestaurantDAO dao = RestaurantDAO.getRestaurantDAO();
		 int result= dao.insertRestaurantInfo(vo);
		 request.setAttribute("result", result);
		 String viewPath = "list?command=insertRestaurantInfoForm";
		 ActionHelper.getActionHelper().actionFoward(request, response, viewPath);
		
	}

	@Override
	public Object[] getDataBinders() {
		// TODO Auto-generated method stub
		return new Object[]{"restaurantVO", com.mc.delivery.vo.RestaurantVO.class};
	}

}
