package com.mc.delivery.controller.listcontroller;

import java.io.IOException;

import java.util.HashMap;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mc.delivery.action.Action;
import com.mc.delivery.action.ActionFactory;
import com.mc.delivery.databinding.DataBinding;
import com.mc.delivery.databinding.ServletRequestDataBinder;
@WebServlet(urlPatterns="/list")
public class ListController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//나중에 이 모델이 정보를 담고 뷰단으로 갈수도 있고, 서버단으로도 쓰일수있다. 단 . 컨트롤러로 제어권을 가져와야한다. 
	HashMap<String, Object> model= new HashMap<>();	
		
	String command= req.getParameter("command");
	System.out.println("컨트롤러에 입력된 커맨드 잘되나:"+ command);
	ActionFactory af= ActionFactory.getActionFactory();
	Action action =  af.getAction(command);
	
	// 데이타 바인딩을 구현한 객체인지 확인하여 데이터바인딩을 구현했으면 컨트롤러쪽에 vo객체를 준비해줄수 있게 한다.
	if(action instanceof DataBinding){
		prepareRequestData(req,model,(DataBinding)action);
	}
	if(action!=null){
		action.execute(req, resp);
	}
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		this.doGet(req, resp);
	
	}
	
	
	/// 데이타 바인딩 연습 및 적용
	public void prepareRequestData(HttpServletRequest req, HashMap<String, Object> model, DataBinding databinding){
		Object[] databind= databinding.getDataBinders();
		String dataName=null;
		Class<?> dataType=null;
		Object dataObj=null;
		
		for(int i=0;i<databind.length;i+=2){
			dataName=(String)databind[i];
			dataType=(Class<?>)databind[i+1];
			try {
				dataObj=ServletRequestDataBinder.bind(req, dataType, dataName);
				model.put(dataName, dataObj);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	
}
