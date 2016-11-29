package com.mc.delivery.vo;

public class RestaurantVO {
	private int restaurantId;
	private String restaurantName;
	private String restaurantLocation;
	private String restaurantCategory;
	private String restaurantImg;
	private String restaurantOpenTime;
	private String restaurantCloseTime;
	private String restaurantIntro;
	private String restaurantPhone;
	
	public String getRestaurantOpenTime() {
		return restaurantOpenTime;
	}
	public void setRestaurantOpenTime(String restaurantOpenTime) {
		this.restaurantOpenTime = restaurantOpenTime;
	}
	public String getRestaurantCloseTime() {
		return restaurantCloseTime;
	}
	public void setRestaurantCloseTime(String restaurantCloseTime) {
		this.restaurantCloseTime = restaurantCloseTime;
	}
	public String getRestaurantIntro() {
		return restaurantIntro;
	}
	public void setRestaurantIntro(String restaurantIntro) {
		this.restaurantIntro = restaurantIntro;
	}
	public String getRestaurantPhone() {
		return restaurantPhone;
	}
	public void setRestaurantPhone(String restaurnatPhone) {
		this.restaurantPhone = restaurnatPhone;
	}
	public String getRestaurantImg() {
		return restaurantImg;
	}
	public void setRestaurantImg(String restaurantImg) {
		this.restaurantImg = restaurantImg;
	}
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
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
