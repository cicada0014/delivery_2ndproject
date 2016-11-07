package com.mc.delivery.vo;

public class RestaurantVO {
	private String restaurantId;
	private String restaurantName;
	private String restaurantLocation;
	private String restaurantCategory;
	private String restaurantImg;
	public String getRestaurantImg() {
		return restaurantImg;
	}
	public void setRestaurantImg(String restaurantImg) {
		this.restaurantImg = restaurantImg;
	}
	public String getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(String restaurantId) {
		this.restaurantId = restaurantId;
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public String getRestaurantLocation() {
		return restaurantLocation;
	}
	public void setRestaurantLocation(String restaurantLocation) {
		this.restaurantLocation = restaurantLocation;
	}
	public String getRestaurantCategory() {
		return restaurantCategory;
	}
	public void setRestaurantCategory(String restaurantCategory) {
		this.restaurantCategory = restaurantCategory;
	}
	public RestaurantVO() {
		super();
	}
}
