package com.mc.delivery.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MapAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/xml;charset=UTF-8");
		String sessionLocation = request.getParameter("sessionLocation");
		if(sessionLocation != null){
			request.getSession().setAttribute("sessionLocation", sessionLocation);
			System.out.println(sessionLocation);
		}
		String lat = request.getParameter("lat");
		String lng = request.getParameter("lng");

		String clientId = "JKvjluyyeKcMUDL2j_l6";// 애플리케이션 클라이언트 아이디값";
		String clientSecret = "GgtDduxZyB";// 애플리케이션 클라이언트 시크릿값";
		try {
			String addr = lng + "," + lat;
			String apiURL = "https://openapi.naver.com/v1/map/reversegeocode?"
					+ "encoding=utf-8&coord=latlng&output=json&query=" + addr;
			System.out.println(apiURL);
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("X-Naver-Client-Id", clientId);
			con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
			int responseCode = con.getResponseCode();
			BufferedReader br;
			if (responseCode == 200) { // 정상 호출
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else { // 에러 발생
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			String inputLine;
			StringBuffer result = new StringBuffer();
			while ((inputLine = br.readLine()) != null) {
				result.append(inputLine);
			}
			
			br.close();
			
			System.out.println(result.toString());
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(result.toString());
			
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

}
