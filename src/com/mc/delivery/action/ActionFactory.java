package com.mc.delivery.action;

import com.mc.delivery.action.restaurantaction.InsertRestaurantAction;
import com.mc.delivery.action.restaurantaction.InsertRestaurantInfoFormAction;
import com.mc.delivery.action.restaurantaction.SelectCategoryListAction;
import com.mc.delivery.action.restaurantaction.TakeListAction;

public class ActionFactory {
//////////////////////////액션 팩토리 싱글톤 패턴 생성
	private static ActionFactory instance;
	private ActionFactory(){
		
	}
	public static ActionFactory getActionFactory(){
		if(instance==null){
			instance= new ActionFactory();
		}
	
		return instance;
	}
//////////////////////////	액션객체 생성해내는 메소드를 지닌다.
	public Action getAction(String command){
		Action commandAction =null;
		
		if(command==null||command.equals("")){
			commandAction = new MainAction();
		}else if(command.equals("takeList")){
			commandAction = new TakeListAction();
		}else if(command.equals("insertRestaurantInfo")){
			commandAction=new InsertRestaurantAction();
		}else if(command.equals("selectCategoryList")){
			commandAction = new SelectCategoryListAction();
		}else if(command.equals("insertRestaurantInfoForm")){
			commandAction= new InsertRestaurantInfoFormAction();
		}else if(command.equals("listAjax")){
			commandAction = new AjaxAction();
		}
		
		
		return commandAction;
	}
	
	
	
	
}
