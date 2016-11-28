package com.mc.delivery.service;

import com.mc.delivery.dao.MenuDAO;
import com.mc.delivery.dao.RestaurantDAO;
import com.mc.delivery.vo.MenuVO;
import com.mc.delivery.vo.RestaurantVO;

public class MenuService {
	private static MenuService instance;
	public static MenuService getInstance()
	{
		if(instance == null)
			instance = new MenuService();
		return instance;
	}
	private MenuService(){}
		
	public int insert(MenuVO vo)
	{
		MenuDAO dao = MenuDAO.getInstance();
		return dao.insertMenuInfo(vo);
	}
	
	public MenuVO read(int restaurantId)
	{
		MenuDAO dao = MenuDAO.getInstance();
		MenuVO result = dao.selectMenu(restaurantId);
		
		return result;
	}
}
