package com.chainsys.webapp.first;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.logging.LogManager;
import com.chainsys.miniproject.commonutil.LogMannager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.miniproject.commonutil.ExceptionManager;
import com.chainsys.miniproject.commonutil.HTMLHelper;
import com.chainsys.miniproject.commonutil.InValidInputDataException;
import com.chainsys.miniproject.commonutil.Validator;
import com.chainsys.miniproject.dao.EmployeeDao;
import com.chainsys.miniproject.pojo.Employee;

/**
 * Servlet implementation class Employees
 */
public class Employees extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Employees() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		List<Employee> emplist = EmployeeDao.getAllEmployee();
		Iterator<Employee> empItr = emplist.iterator();
		while (empItr.hasNext()) {
			Employee emp = empItr.next();

			out.println("<hr/>");
			out.println(emp.getEmployee_id() + "," + emp.getFirst_name() + "," + emp.getLast_name() + ","
					+ emp.getEmail() + "," + emp.getJob_id() + "," + emp.getSalary() + "</p>");

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	String submitvalue=request.getParameter("submit");
	
	if(submitvalue.equals("Add employee")) {
		PrintWriter out=response.getWriter();
		Employee emp=new Employee();
		String emp_id=request.getParameter("id");
	String source="AddNewEmployee";
	String message="<h1>Error while"+source+"</h1>";
	try {
		Validator.checkStringForParseInt(emp_id);
	}catch(InValidInputDataException e) {
	  message +="Error in employee id input <p/>";	
		String errorPage=ExceptionManager.handleException(e, source, message);
		out.print(errorPage);
		return;	
	}
	int id=Integer.parseInt(emp_id);
	try {
		Validator.CheckNumberForGreaterThanZero(id);
	}catch(InValidInputDataException e) {
		 message +="Error in employee id input <p/>";	
			String errorPage=ExceptionManager.handleException(e, source, message);
			out.print(errorPage);
			return;	
	}
	emp.setEmployee_id(id);
	
	
	String emp_Firstname=request.getParameter("fname");
	try {
		Validator.checkStringOnly(emp_Firstname);
	}catch(InValidInputDataException e) {
		 message +="Error in employee fname input <p/>";	
			String errorPage=ExceptionManager.handleException(e, source, message);
			out.print(errorPage);
			return;		
	}
	emp.setFirst_name(emp_Firstname);
	
	
	String emp_LastName=request.getParameter("lname");
	try {
		Validator.checkStringOnly(emp_LastName);
	}catch(InValidInputDataException e) {
		 message +="Error in employee lname input <p/>";	
			String errorPage=ExceptionManager.handleException(e, source, message);
			out.print(errorPage);
			return;	
	}
	emp.setLast_name(emp_LastName);
	
	
	
	
    String emp_email=request.getParameter("email");
    try {
		Validator.checkEmail(emp_email); 
	}catch(InValidInputDataException e) {
		 message +="Error in employee email input <p/>";	
			String errorPage=ExceptionManager.handleException(e, source, message);
			out.print(errorPage);
			return;	
	}
    emp.setEmail(emp_email);
    
    
    
    SimpleDateFormat hire_dateFormate=new SimpleDateFormat("dd/MM/yyyy");
    String emp_HireDate=request.getParameter("hdate");
    //Date hire_date=hire_dateFormate.parse(emp_HireDate);
    try {
		emp.setHire_date(hire_dateFormate.parse(emp_HireDate));
	} catch (ParseException e) {
		 message +="Error in employee hdate input <p/>";	
			String errorPage=ExceptionManager.handleException(e, source, message);
			out.print(errorPage);
			return;	
	}
    
    
    
    String emp_Job_id=request.getParameter("jobid");
    try {
    	Validator.checkJobId(emp_Job_id);
    }catch(InValidInputDataException e) {
    	 message +="Error in employee jobid input <p/>";	
 		String errorPage=ExceptionManager.handleException(e, source, message);
 		out.print(errorPage);
 		return;	
    }
    emp.setJob_id(emp_Job_id);
    
    
    
    String emp_salary=request.getParameter("salary");
    try {
		Validator.checkStringForParseInt(emp_salary);
	}catch(InValidInputDataException e) {
		 message +="Error in employee salary input <p/>";	
			String errorPage=ExceptionManager.handleException(e, source, message);
			out.print(errorPage);
			return;	
	}
    float salary=Float.parseFloat(emp_salary);
    emp.setSalary(salary);
    int result=EmployeeDao.insertEmployee(emp);
    System.out.println(result+"row inserted");
	
}
	else if(submitvalue.equals("update employee"))
	{doPut(request,response);
	}
	else if(submitvalue.equals("delete"))
	{
		doDelete(request,response);
	}
	}
	
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		Employee emp=new Employee();
		//System.out.println("Enter the Employee id:");
		String emp_id=null;
		 emp_id=request.getParameter("id");
		try {
			//emp_id=sc.nextLine();
			Validator.checkStringForParseInt(emp_id);
		}catch(InValidInputDataException e) {
			
			e.printStackTrace();
			return;	
		}
		int id=Integer.parseInt(emp_id);
		try {
			Validator.CheckNumberForGreaterThanZero(id);
		}catch(InValidInputDataException e) {
			e.printStackTrace();
			return;	
		}
		emp.setEmployee_id(id);
		
		
		System.out.println("Enter Employee first name:");
		String emp_Firstname=request.getParameter("fname");
		try {
			Validator.checkStringOnly(emp_Firstname);
		}catch(InValidInputDataException e) {
			e.printStackTrace();
			return;	
		}
		emp.setFirst_name(emp_Firstname);
		System.out.println("Enter Employee Last Name:");
		String emp_LastName=request.getParameter("lname");
		try {
			Validator.checkStringOnly(emp_LastName);
		}catch(InValidInputDataException e) {
			e.printStackTrace();
			return;	
		}
		emp.setLast_name(emp_LastName);
	    System.out.println("Enter Employee Email:");
	    String emp_email=request.getParameter("email");
	    try {
			Validator.checkEmail(emp_email);
		}catch(InValidInputDataException e) {
			e.printStackTrace();
			return;	
		}
	    emp.setEmail(emp_email);
	    System.out.println("Enter Employee hire_date like \"dd/mm/yyyy\":");
	    SimpleDateFormat hire_dateFormate=new SimpleDateFormat("dd/MM/yyyy");
	    String emp_HireDate=request.getParameter("hdate");
	    //Date hire_date=hire_dateFormate.parse(emp_HireDate);
	    try {
			emp.setHire_date(hire_dateFormate.parse(emp_HireDate));
		} catch (ParseException e) {
			e.printStackTrace();
			return;	
		}
	    System.out.println("Enter the job_id:");
	    String emp_Job_id=request.getParameter("jobid");
	    try {
	    	Validator.checkJobId(emp_Job_id);
	    }catch(InValidInputDataException e) {
			e.printStackTrace();
			return;	
	    }
	    emp.setJob_id(emp_Job_id);
	    System.out.println("Enter Salary of Employee:");
	    String emp_salary=request.getParameter("salary");
	    try {
	    	Validator.checkStringForParseInt(emp_salary);
	    }catch(InValidInputDataException e) {
			e.printStackTrace();
			return;	
	    }
	    float salary=Float.parseFloat(emp_salary);
	    emp.setSalary(salary);
	    int result=EmployeeDao.updateEmployee(emp);
	    out.println(result+"row updated");
	   // sc.close();
	}
	
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		Employee emp=new Employee();
		
		
		String emp_id=request.getParameter("id");
		try {
			Validator.checkStringForParseInt(emp_id);
		}catch(InValidInputDataException e) {
			e.printStackTrace();
			System.exit(-1);	
		}
		int id=Integer.parseInt(emp_id);
		try {
			Validator.CheckNumberForGreaterThanZero(id);
		}catch(InValidInputDataException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		
		emp.setEmployee_id(id);
		
		int result = EmployeeDao.deleteEmployee(id);
		out.println(result+"row updated");
}
}