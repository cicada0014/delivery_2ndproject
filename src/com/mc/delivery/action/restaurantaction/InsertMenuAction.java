package com.mc.delivery.action.restaurantaction;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mc.delivery.action.Action;
import com.mc.delivery.action.ActionHelper;
import com.mc.delivery.dao.MenuDAO;
import com.mc.delivery.databinding.DataBinding;
import com.mc.delivery.vo.MenuVO;
import com.oreilly.servlet.MultipartRequest;

public class InsertMenuAction implements Action,DataBinding {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MultipartRequest multi = (MultipartRequest) request.getAttribute("multi");
		
		String restaurantId = multi.getParameter("restaurantId");
		String menuId = multi.getParameter("menuId");
		String menuName = multi.getParameter("menuName");
		String menuCategory = multi.getParameter("menuCategory");
		String menuInfo= multi.getParameter("menuInfo");
		String menuPrice = multi.getParameter("menuPrice");
		String menuImgPath = multi.getParameter("menuImgPath");
		
		System.out.println(menuName);
		System.out.println(menuCategory);
		System.out.println(menuInfo);
		System.out.println(menuPrice);
		
		String menuImageFileName = "default_img.png";
		
		if(multi.getFilesystemName("menuImg") == null || multi.getFilesystemName("menuImg").equals(""))
		{	
		}
		else
		{
			menuImageFileName = multi.getFilesystemName("menuImg");
		}
		
		MenuVO vo = new MenuVO();
		vo.setMenuName(menuName);
		vo.setMenuCategory(menuCategory);
		vo.setMenuInfo(menuInfo);
		vo.setMenuPrice(Integer.parseInt(menuPrice));
		vo.setMenuImagePath(menuImageFileName);
		
		ServletContext sc = request.getServletContext();
		sc.getAttribute("menuDAO");
		MenuDAO dao = (MenuDAO) sc.getAttribute("menuDAO");
		
		int result = dao.insertMenuInfo(vo);
		request.setAttribute("result", result);
		String viewPath = "result.jsp"; //result.jsp는 임시
		ActionHelper.getActionHelper().actionFoward(request, response, viewPath);
	}
	
	@Override
	public Object[] getDataBinders()
	{
		return new Object[]{"menuVO", com.mc.delivery.vo.MenuVO.class};
	}
}
