package com.mc.delivery.controller.menucontroller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mc.delivery.action.Action;
import com.mc.delivery.action.ActionFactory;
import com.mc.delivery.databinding.DataBinding;
import com.mc.delivery.databinding.ServletRequestDataBinder;

@WebServlet(urlPatterns="/menuList")
public class MenuListController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HashMap<String, Object> model = new HashMap<>();
		
		String restaurantMenu = req.getParameter("restaurantMenu");
		String menuScore = req.getParameter("menuScore");
		System.out.println("컨트롤러에 입력된 메뉴 커맨드 : " + restaurantMenu);
		System.out.println("컨트롤러에 입력된 평가 커맨드 : " + menuScore);
		ActionFactory af = ActionFactory.getActionFactory();
		Action menuAction = af.getAction(restaurantMenu);
		Action scoreAction = af.getAction(menuScore);
		
		if(menuAction instanceof DataBinding)
		{
			prepareRequestData(req, model, (DataBinding) menuAction);
			if(scoreAction instanceof DataBinding)
			{
				prepareRequestData(req, model, (DataBinding) scoreAction);
			}
		}
		
		if(menuAction != null)
		{
			menuAction.execute(req, resp);
			if(scoreAction != null)
			{
				scoreAction.execute(req, resp);
			}
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		this.doGet(req, resp);
	}
	
	//데이터 바인딩
	public void prepareRequestData(HttpServletRequest req, HashMap<String, Object> model, DataBinding databinding)
	{
		Object[] databind = databinding.getDataBinders();
		String dataName = null;
		Class<?> dataType = null;
		Object dataObj = null;
		for(int i=0; i<databind.length; i+=2)
		{
			dataName = (String) databind[i];
			dataType = (Class<?>) databind[i+1];
			
			try {
				dataObj = ServletRequestDataBinder.bind(req, dataType, dataName);
				model.put(dataName, dataObj);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
