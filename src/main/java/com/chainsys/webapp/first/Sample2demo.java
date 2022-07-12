package com.chainsys.webapp.first;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Sample2demo
 */
@WebServlet("/Sample2demo")
public class Sample2demo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sample2demo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		 {        
		       response.setContentType("text/html");      
		       PrintWriter pwriter = response.getWriter();                
		       String name=request.getParameter("uname");      
		       String pass=request.getParameter("upass");                
		       if(name.equals("Chaitanya") && 
		          pass.equals("beginnersbook"))
		       {          
		          RequestDispatcher dis=request.getRequestDispatcher("Samplewelcome");          
		          dis.forward(request, response);      
		       }     
		       else
		       {      
		          pwriter.print("User name or password is incorrect!");          
		          RequestDispatcher dis=request.getRequestDispatcher("Sample2");          
		          dis.include(request, response);                                
		       }      
		   }    
	}

}
