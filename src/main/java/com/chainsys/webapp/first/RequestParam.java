package com.chainsys.webapp.first;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class InitPara
 */
public class RequestParam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestParam() {
        super();
      
    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doPost called");
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		//HttpSession ses = request.getSession(true);
		String str_name = (String)request.getParameter("name");//get data from browser, similar to scanner.readline();
		out.println("<div>"+str_name+"</div>");
		String str_company = (String)request.getParameter("company");
		out.println("</div>"+str_company+"</div>");
	/*	Enumeration enu = getInitParameterNames();//enumerator has a iterator
		  while(enu.hasMoreElements())
		    {
		  		String init = (String)enu.nextElement();
		  		out.println(init+" : " +getInitParameter(init)+"<br>");
		  	}*/
		out.println("inside");
		
	}

}
