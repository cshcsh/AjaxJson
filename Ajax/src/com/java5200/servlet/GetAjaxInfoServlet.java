package com.java5200.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class GetAjaxInfoServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		this.ejld(request, response);

	}

	private void ejld(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String shengId = request.getParameter("shengId");
		JSONObject resultJson = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		JSONObject temp = null;
		switch (Integer.parseInt(shengId)) {
		case 0: {
			temp = new JSONObject();
			temp.put("id", 0);
			temp.put("text", "请选择");
			jsonArray.add(temp);
			break;
		}
		case 1: {
			temp = new JSONObject();
			temp.put("id", 1);
			temp.put("text", "南京市");
			jsonArray.add(temp);
			temp = new JSONObject();
			temp.put("id", 2);
			temp.put("text", "南通市");
			jsonArray.add(temp);
			temp = new JSONObject();
			temp.put("id", 3);
			temp.put("text", "泰兴市");
			jsonArray.add(temp);
			break;
		}
		case 2: {
			temp = new JSONObject();
			temp.put("id", 4);
			temp.put("text", "济南市");
			jsonArray.add(temp);
			temp = new JSONObject();
			temp.put("id", 5);
			temp.put("text", "烟台市");
			jsonArray.add(temp);
			temp = new JSONObject();
			temp.put("id", 6);
			temp.put("text", "蓬莱市");
			jsonArray.add(temp);
			break;
		}
		case 3: {
			temp = new JSONObject();
			temp.put("id", 7);
			temp.put("text", "杭州市");
			jsonArray.add(temp);
			temp = new JSONObject();
			temp.put("id", 8);
			temp.put("text", "宁波市");
			jsonArray.add(temp);
			temp = new JSONObject();
			temp.put("id", 9);
			temp.put("text", "温州市");
			jsonArray.add(temp);
			break;
		}
		}
		resultJson.put("rows", jsonArray);
		out.println(resultJson);
		out.flush();
		out.close();
	}

}
