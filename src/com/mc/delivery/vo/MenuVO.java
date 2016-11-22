package com.mc.delivery.vo;

public class MenuVO {
	private int restaurantId;
	private int menuId;
	private String menuCategory;
	private String menuName;
	private String menuInfo;
	private int menuPrice;
	private int menuScore;
	private String menuImagePath;
	
	public MenuVO() {
	}

	public MenuVO(int restaurantId, int menuId, String menuCategory, String menuName, String menuInfo, int menuPrice,
			int menuScore, String menuImagePath) {
		this.restaurantId = restaurantId;
		this.menuId = menuId;
		this.menuCategory = menuCategory;
		this.menuName = menuName;
		this.menuInfo = menuInfo;
		this.menuPrice = menuPrice;
		this.menuScore = menuScore;
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

	public String getMenuCategory() {
		return menuCategory;
	}

	public void setMenuCategory(String menuCategory) {
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

	public int getMenuScore() {
		return menuScore;
	}

	public void setMenuScore(int menuScore) {
		this.menuScore = menuScore;
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
				+ ", menuName=" + menuName + ", menuInfo=" + menuInfo + ", menuPrice=" + menuPrice + ", menuScore="
				+ menuScore + ", menuImagePath=" + menuImagePath + "]";
	}
}