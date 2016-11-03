package com.mc.delivery.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
// 액션 인터페이스로서 실행 메소드를 갖는다,리퀘스트객체와 리스폰스 객체를 매개변수로 한다.
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException;
	
	
}
