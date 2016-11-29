package com.mc.delivery.service;

import java.util.List;

import com.mc.delivery.dao.MenuDAO;
import com.mc.delivery.vo.MenuVO;

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
	
	public List<MenuVO> readList(int restaurantId)
	{
		MenuDAO dao = MenuDAO.getInstance();
		List<MenuVO> menuList = dao.selectMenuList(restaurantId);
		
//		return menuList;
		System.out.println(menuList);
		return menuList;
	}
}