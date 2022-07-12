package com.chainsys.webapp.first;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *  * Servlet implementation class AttributesDemo  
 */
public class AttributesDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;

//* @see HttpServlet#HttpServlet()

    public AttributesDemo() {
    	super();
    }

	/**
	 *      * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 * response)      
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
	public String salary=null;

/**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 PrintWriter out= response.getWriter();
		    response.setContentType("text/html");
		    out.println("<html><head><title>Attributes</title></head><body>");
		 String submitvalue=request.getParameter("submit");
		if(submitvalue.equals("set"))
		{
		 
		 String salaryInput=request.getParameter("salary");
		    salary=salaryInput;//storing data in global variable
		    out.println("<h1>value set</h1>" + salary);//return value
		}
		else if(submitvalue.equals("fetch"))
		{
		    out.println("<h1>value fetched</h1> "+ salary);
		}
		    out.println("</body></html");
		        
		    }

}
