package com.bridgeit.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FirstServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		
		
		resp.setContentType("text/html");
		
		
		
		PrintWriter out=resp.getWriter();
		
		
		out.println("<html><body><h1>"+"Hi " + req.getParameter("nm")+" Welcome to "+req.getParameter("pl")+"</h1></body></html>");
		out.flush();
		out.close();
		
		
		
		
		
	}
	

}
