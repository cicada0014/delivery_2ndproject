package com.mc.delivery.service;

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
}
