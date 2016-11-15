package com.mc.delivery.vo;

public class MenuScoreVO {
	private int menuId;
	private int commentId;
	private String userName;
	private String menuComment;
	private String commentImgPath;
	
	public MenuScoreVO(int menuId, String userName, String menuComment, String commentImgPath) {
		this.menuId = menuId;
		this.userName = userName;
		this.menuComment = menuComment;
		this.commentImgPath = commentImgPath;
	}

	public MenuScoreVO(int menuId, String userName, String menuComment) {
		this.menuId = menuId;
		this.userName = userName;
		this.menuComment = menuComment;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
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

	public String getMenuComment() {
		return menuComment;
	}

	public void setMenuComment(String menuComment) {
		this.menuComment = menuComment;
	}

	public String getCommentImgPath() {
		return commentImgPath;
	}

	public void setCommentImgPath(String commentImgPath) {
		this.commentImgPath = commentImgPath;
	}

	@Override
	public String toString() {
		return "MenuScoreVO [menuId=" + menuId + ", commentId=" + commentId + ", userName=" + userName
				+ ", menuComment=" + menuComment + ", commentImgPath=" + commentImgPath + "]";
	}
}
