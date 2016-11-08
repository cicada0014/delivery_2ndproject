package com.mc.delivery.scopeListener;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;

import com.mc.delivery.dao.RestaurantDAO;
import com.mc.delivery.jdbcutil.DBHelper;
@WebListener
public class ContextLoaderListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		
		
		
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		ServletContext sc = event.getServletContext();
		InitialContext initialContext;
		RestaurantDAO restaurantDAO = RestaurantDAO.getRestaurantDAO();
		try {
			initialContext = new InitialContext();
			DataSource ds = (DataSource) initialContext.lookup("java:comp/env/jdbc/mydb");
			restaurantDAO.setDataSource(ds);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sc.setAttribute("restaurantDAO", restaurantDAO);
	}

}
