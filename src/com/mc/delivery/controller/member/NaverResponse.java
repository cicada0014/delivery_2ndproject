package com.mc.delivery.controller.member;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


/**
 * Servlet implementation class NaverServlet
 */
@WebServlet("/callback")
public class NaverResponse extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("������ id : " + request.getParameter("id"));
		System.out.println("������ sig : " + request.getParameter("signature"));
		
		execute(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		execute(request, response);
	}

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String clientId = "uu92Htfoiw_nrsRdhMeE";
		String clientSecret = "z7IT5LpAXD";

		String code = request.getParameter("code");
		String state = request.getParameter("state");
		
		int resCode = 0;


		String redirectURI = URLEncoder.encode("http://70.12.109.108:8080/callback.jsp", "UTF-8");
		String apiURL = "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code&";
		apiURL += "client_id=" + clientId;
		apiURL += "&client_secret=" + clientSecret;
		apiURL += "&redirect_uri=" + redirectURI;
		apiURL += "&code=" + code;
		apiURL += "&state=" + state;

		String access_token = "";
		String refresh_token = "";
		String token_type = "";

		// ���úκ�
		///////////
		// ����κ�

		try {
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			resCode = con.getResponseCode();
			BufferedReader br = null;

			System.out.println("resCode = " + resCode);

			if (resCode == 200) {
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}

			String inputLine;
			StringBuffer res = new StringBuffer();

			while ((inputLine = br.readLine()) != null) {
				res.append(inputLine);
			}
			br.close();

			if (resCode == 200) {
				// ���� ������ JSON ��ü�� �����´�
				
				JSONParser jsonParser = new JSONParser();
				JSONObject jsonObject = (JSONObject) jsonParser.parse(res.toString());
				
				System.out.println("access_token : " + jsonObject.get("access_token"));
				System.out.println("refresh_token : " + jsonObject.get("refresh_token"));
				System.out.println("token_type : " + jsonObject.get("token_type"));
				System.out.println("expires_in : " + jsonObject.get("expires_in"));
				
				access_token = (String) jsonObject.get("access_token");
				refresh_token = (String) jsonObject.get("refresh_token");
				token_type = (String) jsonObject.get("token_type");
				
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		
		System.out.println("==========================================");
		
		//
		////
		// ���̹� ����� ���� ��������
		
		//���� ����
		
		String naver_nick = "";
		String naver_email = "";
		
		
		try {
			apiURL = "https://openapi.naver.com/v1/nid/me";

			
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			//con.setRequestMethod("GET");
			con.setRequestProperty("Authorization", token_type + " " + access_token);
			resCode = con.getResponseCode();
			BufferedReader br = null;

			System.out.println("resCode = " + resCode);

			if (resCode == 200) {
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}

			String inputLine;
			StringBuffer res = new StringBuffer();

			while ((inputLine = br.readLine()) != null) {
				res.append(inputLine);
			}
			br.close();
			
			if (resCode == 200) {
				// ���� ������ JSON ��ü�� �����´�
				
				JSONParser jsonParser = new JSONParser();
				JSONObject jsonObject = (JSONObject) jsonParser.parse(res.toString());
				
				JSONObject userInfo = (JSONObject) jsonObject.get("response");
				
				System.out.println("email : " + userInfo.get("email"));
				System.out.println("nickname : " + userInfo.get("nickname"));
				
				naver_email = (String) userInfo.get("email");
				naver_nick = (String) userInfo.get("nickname");
				
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		if(naver_nick.contains("*")){
			naver_nick = naver_email.split("@")[0];
			
			System.out.println("--------------------------------");
			
			
			System.out.println("email : " + naver_email);
			System.out.println("nick : " + naver_nick);
			
			
		}
		
		if(resCode == 200){
		request.getSession().setAttribute("naver_email", naver_email);
		request.getSession().setAttribute("naver_nick", naver_nick);
		
		response.sendRedirect("member.do?action=naverlogin");
		} else {
			response.sendRedirect("/");
		}
		
		//RequestDispatcher dispatcher = request.getRequestDispatcher("naverlogin.jsp");
		//dispatcher.forward(request, response);
		
	}

}
