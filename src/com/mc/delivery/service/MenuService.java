package com.mc.delivery.service;

import java.util.List;

import com.mc.delivery.dao.MenuDAO;
import com.mc.delivery.dao.RestaurantsScoreDAO;
import com.mc.delivery.vo.MenuVO;
import com.mc.delivery.vo.RestaurantsScoreVO;

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
		
		return menuList;
	}
	
	public List<RestaurantsScoreVO> readReply(int restaurantId)
	{
		RestaurantsScoreDAO dao = RestaurantsScoreDAO.getInstance();
		List<RestaurantsScoreVO> replyList = dao.selectRestaurantScoreList(restaurantId);
		
		return replyList;
	}
	
	public int replyInsert(RestaurantsScoreVO vo)
	{
		RestaurantsScoreDAO dao = RestaurantsScoreDAO.getInstance();
		return dao.insertRestaurantScore(vo);
	}
}