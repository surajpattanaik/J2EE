package com.skp.servlet;

import java.io.PrintWriter;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MarriageServlet
 */
@WebServlet("/MarriageServlet")
public class MarriageServlet extends HttpServlet {
	   @Override
		public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException{
			res.setContentType("text/html");
			PrintWriter pw = res.getWriter();
			
	        String name =req.getParameter("name");
			int age =Integer.parseInt(req.getParameter("age"));
			String gender=req.getParameter("gender");

			pw.println("<h1 style='color:maroon;text-align:center'>Shaadi.com </h1>");
			if(gender.equalsIgnoreCase("M")) {
			if(age>=21) {
				pw.println("<h1 style='color:maroon;text-align:center'>Mr "+name+" is eligible for Marriage"+ "</h1>"); }

			else {
				pw.println("<h1 style='color:maroon;text-align:center'>Mr "+name+" is not eligible for Marriage, wait for "+(21-age)+"year."+ "</h1>");}

			} else{
				if(age>=18) {
					pw.println("<h1 style='color:maroon;text-align:center'>Miss "+name+" is eligible for Marriage"+ "</h1>"); }

				else {
					pw.println("<h1 style='color:maroon;text-align:center'>Miss "+name+" is not eligible for Marriage, wait for "+(18-age)+"year."+ "</h1>");
				}
				
			}
	        pw.println("<a href='http://localhost:3030/MarriageApp/index.html'><img src='images/home.png' width='60' height='50'</a>");
			pw.close();
	   }
}
