package com.mc.delivery.controller.menucontroller;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mc.delivery.dao.MenuDAO;
import com.mc.delivery.dao.RestaurantDAO;
import com.mc.delivery.service.MenuService;
import com.mc.delivery.vo.MenuVO;
import com.mc.delivery.vo.RestaurantVO;
import com.mc.delivery.vo.RestaurantsScoreVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet(urlPatterns="/menuList.do")
public class MenuListController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		execute(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		execute(req, resp);
	}
	
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String viewPath = "";
		String action = req.getParameter("action");
		
		MenuService service = MenuService.getInstance();
		
		ServletContext sc = req.getServletContext();
	 	RestaurantDAO dao = (RestaurantDAO) sc.getAttribute("restaurantDAO");
		
		if( action.equals("menuList")|| action == null )
		{
			String restaurantIdStr = req.getParameter("restaurantId");
			int restaurantId = Integer.parseInt(restaurantIdStr);
			
			MenuVO vo = service.read(restaurantId);
			RestaurantVO restaurant = dao.selectByRestaurantId(restaurantId);
			req.setAttribute("menuVO", vo);
			req.setAttribute("restaurant", restaurant);
			viewPath = "menu.jsp";
		}
		else if(action.equals("insertMenuForm"))
		{
			viewPath = "insertMenu_form.jsp";
		}
		else if(action.equals("insertMenu"))
		{
			String restaurantIdStr = req.getParameter("restaurantName");
			int restaurantId = Integer.parseInt(restaurantIdStr);
			
			String menuCategory = req.getParameter("menuCategory");
			String menuName = req.getParameter("menuName");
			String menuInfo = req.getParameter("menuInfo");
			String menuPrice = req.getParameter("menuPrice");
			String menuImgPath = req.getParameter("menuImgPath");
			
			String menuImgFolder = "http://70.12.109.97:9090/";
			MultipartRequest mRequest = new MultipartRequest(req, menuImgFolder, 1024 * 1024 * 5, "utf-8", new DefaultFileRenamePolicy());
			
			File file = mRequest.getFile("uploadFile");
			
			MenuVO vo = new MenuVO();
			vo.setRestaurantId(restaurantId);
			vo.setMenuCategory(Integer.parseInt(menuCategory));
			vo.setMenuName(menuName);
			vo.setMenuInfo(menuInfo);
			vo.setMenuPrice(Integer.parseInt(menuPrice));
			vo.setMenuImagePath(menuImgPath);
//			vo.setMenuImagePath(file.getAbsolutePath());
			
			int result = service.insert(vo);
			req.setAttribute("insertResult", result);
			viewPath = "insertMenu_result.jsp";
		}
		else if(action.equals("insertScoreForm"))
		{
			viewPath = "insertScore_form.jsp";
		}
		else if(action.equals("insertScore"))
		{
			String restaurantIdStr = req.getParameter("restaurantName");
			int restaurantId = Integer.parseInt(restaurantIdStr);
			
			String userName = req.getParameter("userName");
			String restaurantComment = req.getParameter("restaurantComment");
			String commentImgPath = req.getParameter("commentImgPath");
			
			RestaurantsScoreVO vo = new RestaurantsScoreVO();
			vo.setRestaurantId(restaurantId);
			vo.setUserName(userName);
			vo.setRestaurantComment(restaurantComment);
			vo.setCommentImgPath(commentImgPath);
			
			int result = service.replyInsert(vo);
			req.setAttribute("insertScore", result);
			viewPath = "insertScore_result.jsp";
		}
		RequestDispatcher dispatcher = req.getRequestDispatcher(viewPath);
		dispatcher.forward(req, resp);
	}
}
