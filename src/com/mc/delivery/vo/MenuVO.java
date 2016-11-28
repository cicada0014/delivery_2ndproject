package com.mc.delivery.vo;

public class MenuVO {
	private int restaurantId;
	private int menuId;
	private int menuCategory;
	private String menuName;
	private String menuInfo;
	private int menuPrice;
	private String menuImagePath;
		
	public MenuVO() {
	}

	public MenuVO(int restaurantId, int menuId, int menuCategory, String menuName, String menuInfo, int menuPrice, String menuImagePath) {
		this.restaurantId = restaurantId;
		this.menuId = menuId;
		this.menuCategory = menuCategory;
		this.menuName = menuName;
		this.menuInfo = menuInfo;
		this.menuPrice = menuPrice;
		this.menuImagePath = menuImagePath;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public int getMenuCategory() {
		return menuCategory;
	}

	public void setMenuCategory(int menuCategory) {
		this.menuCategory = menuCategory;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuInfo() {
		return menuInfo;
	}

	public void setMenuInfo(String menuInfo) {
		this.menuInfo = menuInfo;
	}

	public int getMenuPrice() {
		return menuPrice;
	}

	public void setMenuPrice(int menuPrice) {
		this.menuPrice = menuPrice;
	}

	public String getMenuImagePath() {
		return menuImagePath;
	}

	public void setMenuImagePath(String menuImagePath) {
		this.menuImagePath = menuImagePath;
	}

	@Override
	public String toString() {
		return "MenuVO [restaurantId=" + restaurantId + ", menuId=" + menuId + ", menuCategory=" + menuCategory
				+ ", menuName=" + menuName + ", menuInfo=" + menuInfo + ", menuPrice=" + menuPrice + ", menuImagePath="
				+ menuImagePath + "]";
	}
}
