package com.chainsys.webapp.second;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.miniproject.pojo.User;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session=request.getSession(true);
		PrintWriter out =response.getWriter();
		User userdata=new User();
		userdata.setUserId(request.getParameter("user"));
		userdata.setPassword(request.getParameter("pwd"));
		String key="user"+session.getId();
		session.setAttribute(key,userdata);
//		doPost(request,response);
		// value bound() in the user class will be added
		response.setContentType("text/html");
		out.print("<div><form action ='/firstWebsite/UserServlet' method='post'> <input type='text' name='txt1' ><p><input type ='submit' name='btn' value='submit'></div>");
		out.print("<p>USER SET TO SESSION!!!");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session=request.getSession(true);
		PrintWriter out =response.getWriter();
		out.print("summa");
		if(session==null) {
			out.print("session not created");
			return;
		}
		else {
			String key="user"+session.getId();
			User userdata=(User)session.getAttribute(key);
			if(userdata==null) {
				out.print("Object removed from session");
				return;
			}
			out.print("<p>user name : "+userdata.getUserId());
			out.print("<p>Passward : "+userdata.getPassword());
			session.removeAttribute("user");
			// this will remove user object from session collection
			// value unbound of the user
//			doGet(request,response);

	}

}}
