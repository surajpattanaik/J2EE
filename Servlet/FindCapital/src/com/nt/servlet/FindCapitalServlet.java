package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class FindCapitalServlet extends HttpServlet {

	 @Override
		public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException{
		PrintWriter pw =  res.getWriter();
		res.setContentType("text/html");
		int countryCode=Integer.parseInt(req.getParameter("coun"));
		String capitals[]= {"New Delhi","Bejing","WashingtonDC","Berlin","Tokyo"};
		pw.println("<h1 style='color:red;text-align:center'>Capital City name is::"+capitals[countryCode]+"</h1>");
		pw.println("<br><a href='input.html'>Home</a>");
		pw.close();
	}
	
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException{
		doPost(req,res);
	}
	
}
