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
			temp.put("text", "��ѡ��");
			jsonArray.add(temp);
			break;
		}
		case 1: {
			temp = new JSONObject();
			temp.put("id", 1);
			temp.put("text", "�Ͼ���");
			jsonArray.add(temp);
			temp = new JSONObject();
			temp.put("id", 2);
			temp.put("text", "��ͨ��");
			jsonArray.add(temp);
			temp = new JSONObject();
			temp.put("id", 3);
			temp.put("text", "̩����");
			jsonArray.add(temp);
			break;
		}
		case 2: {
			temp = new JSONObject();
			temp.put("id", 4);
			temp.put("text", "������");
			jsonArray.add(temp);
			temp = new JSONObject();
			temp.put("id", 5);
			temp.put("text", "��̨��");
			jsonArray.add(temp);
			temp = new JSONObject();
			temp.put("id", 6);
			temp.put("text", "������");
			jsonArray.add(temp);
			break;
		}
		case 3: {
			temp = new JSONObject();
			temp.put("id", 7);
			temp.put("text", "������");
			jsonArray.add(temp);
			temp = new JSONObject();
			temp.put("id", 8);
			temp.put("text", "������");
			jsonArray.add(temp);
			temp = new JSONObject();
			temp.put("id", 9);
			temp.put("text", "������");
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
