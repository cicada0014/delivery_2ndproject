package com.mc.delivery.databinding;

import java.lang.reflect.Method;
import java.sql.Date;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

public class ServletRequestDataBinder {
	public static Object bind(HttpServletRequest req, Class<?> dataType, String dataName) throws Exception{
		if(isPrimitiveType(dataType)){
			return createVlaueObject(dataType, req.getParameter(dataName));
		}
		
		Set<String> paramNames= req.getParameterMap().keySet();
		Object dataObject= dataType.newInstance();
		Method m = null;
		
		for(String paramName : paramNames){
			m=findSetter(dataType, paramName);
			if (m != null) {
				m.invoke(dataObject, createVlaueObject(m.getParameterTypes()[0], req.getParameter(paramName)));
			}
		}
		return dataObject;
	}
	
	
	private static boolean isPrimitiveType(Class<?> type){
		if(type.getName().equals("int") || type==Integer.class ||
		   type.getName().equals("long") || type==Long.class ||
		   type.getName().equals("boolean") || type==Boolean.class ||
		   type==Date.class || type==String.class){
			return true;
		}
		
		return false;
	}
			
	
	private static Object createVlaueObject(Class<?> type, String value){
		if(type.getName().equals("int")||type==Integer.class){
			return new Integer(value);
		}
		else if(type.getName().equals("long")||type==Long.class){
			return new Long(value);
		}
		else if(type.getName().equals("boolean")||type==Boolean.class){
			return new Boolean(value);
		}
		else if(type.getName().equals("int")||type==Integer.class){
			return new Integer(value);
		}
		else if(type==Date.class){
			return Date.valueOf(value);
		}
		else{
			return value;
		}
		
	}
	
	private static Method findSetter(Class<?> type, String name){
		Method[] methods=type.getMethods();
		
		String propName=null;
		for(Method m : methods){
			if(!m.getName().startsWith("set")){
				continue;
			}
			propName=m.getName().substring(3);
			if(propName.toLowerCase().equals(name.toLowerCase())){
				return m;
			}
		}
		return null;
	}
	
	
}
