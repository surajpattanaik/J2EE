package com.skp.servlet;
import jakarta.servlet.*;
import java.io.*;
import java.util.*;
public class DateApp extends GenericServlet{

	public void service(ServletRequest req, ServletResponse res)throws ServletException,IOException{
		//set response content type
		res.setContentType("text/html");
		//get PrintWriter stream object from res obj
		PrintWriter pw = res.getWriter();
		Date d= new Date();
		//write o/p msg to res obj using PrintWriter obj
		pw.println("<b> date and time:: "+d.toString()+"</b>");
		//close stream
		pw.close();
		
	}
}