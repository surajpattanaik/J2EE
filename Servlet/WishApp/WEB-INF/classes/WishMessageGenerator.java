package com.skp.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.time.*; //java 8 

public class WishMessageGenerator extends HttpServlet{

	public void service(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException{

		res.setContentType("text/html");

		PrintWriter pw = res.getWriter();
		
		LocalTime time = LocalTime.now(); 
		int hour=time.getHour();
		String msg=null; 
		if(hour<12)
			msg="Good morning Suraj";
		else if(hour<16)
			msg="Good afternoon Suraj";
		else if(hour<20)
			msg="Good evening Suraj";
		else
			msg="Good night Suraj"; 

		pw.println("<h1 style='color:red;text-align:center'>"+msg+"</h1>");
		pw.println("<a href='http://localhost:2020/WishApp/page.html'>home</a>");
		pw.close();
	}
}