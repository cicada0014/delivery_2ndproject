package com.mc.delivery.autocomplete;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.mc.delivery.dao.RestaurantDAO;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/searchAuto.do")
public class SearchAutoServlet extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		excute(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		excute(request, response);
	}

	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RestaurantDAO DAO = RestaurantDAO.getRestaurantDAO();

		List<String> result = DAO.rs_NameSelectAll();
		
		JSONObject autodata = new JSONObject();
		
		for (int i = 0; i < result.size(); i++){
			//System.out.println(i + " : " + result.get(i));
			autodata.put(result.get(i), null);
		}
		
		response.setContentType("charset=UTF-8");
		//System.out.println(autodata.toString());
		
		response.setCharacterEncoding("UTF-8");
		
		response.getWriter().write(autodata.toString());
	}

}
