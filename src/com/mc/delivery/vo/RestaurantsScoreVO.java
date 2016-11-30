package com.mc.delivery.vo;

public class RestaurantsScoreVO {
	private int restaurantId;
	private int commentId;
	private String userName;
	private String restaurantComment;
	private String commentImgPath;
	
	public RestaurantsScoreVO() {}

	public RestaurantsScoreVO(int restaurantId, String userName, String restaurantComment, String commentImgPath) {
		this.restaurantId = restaurantId;
		this.userName = userName;
		this.restaurantComment = restaurantComment;
		this.commentImgPath = commentImgPath;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRestaurantComment() {
		return restaurantComment;
	}

	public void setRestaurantComment(String restaurantComment) {
		this.restaurantComment = restaurantComment;
	}

	public String getCommentImgPath() {
		return commentImgPath;
	}

	public void setCommentImgPath(String commentImgPath) {
		this.commentImgPath = commentImgPath;
	}

	@Override
	public String toString() {
		return "RestaurantsScoreVO [restaurantId=" + restaurantId + ", commentId=" + commentId + ", userName="
				+ userName + ", restaurantComment=" + restaurantComment + ", commentImgPath=" + commentImgPath + "]";
	}
}
