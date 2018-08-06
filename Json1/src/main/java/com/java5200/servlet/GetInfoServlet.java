package com.java5200.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class GetInfoServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out=resp.getWriter();
		JSONObject result=new JSONObject();
		
		JSONObject object1=new JSONObject();
		object1.put("name", "张三");
		object1.put("age", 22);
		JSONObject score1=new JSONObject();
		score1.put("chinese", 66);
		score1.put("math", 77);
		score1.put("english", 83);
		object1.put("score", score1);
		
		JSONObject object2=new JSONObject();
		object2.put("name", "李四");
		object2.put("age", 22);
		JSONObject score2=new JSONObject();
		score2.put("chinese", 66);
		score2.put("math", 77);
		score2.put("english", 88);
		object2.put("score", score2);
		
		JSONObject object3=new JSONObject();
		object3.put("name", "王五");
		object3.put("age", 24);
		JSONObject score3=new JSONObject();
		score3.put("chinese", 66);
		score3.put("math", 77);
		score3.put("english", 98);
		object3.put("score", score3);
		
		JSONArray array=new JSONArray();
		array.add(object1);
		array.add(object2);
		array.add(object3);
		
		result.put("students", array);
		out.println(result);
		out.flush();
		out.close();
	}

	
}
