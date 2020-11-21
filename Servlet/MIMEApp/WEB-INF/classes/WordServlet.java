package com.skp.servlet;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

public class WordServlet extends HttpServlet{

	protected void service(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException{
		res.setContentType("application/ms-word");
		PrintWriter pw = res.getWriter();
		pw.println("<table border='1' bgcolor='cyan' align='center'>");
		pw.println("<tr><th>Emp_No</th><th>Emp_Name</th><th>Emp_sal</th></tr>");
		pw.println("<tr><td>1</td><td>manjurika</td><td>80,000</td></tr>");
		pw.println("<tr><td>2</td><td>kalyan</td><td>60,000</td></tr>");
		pw.println("<tr><td>3</td><td>sachin</td><td>70,000</td></tr>");
		pw.println("<tr><td>4</td><td>ashrith</td><td>30,000</td></tr>");
		pw.println("<tr><td>5</td><td>somya</td><td>40,000</td></tr>");
		pw.println("</table>");
		pw.close();



	}
}