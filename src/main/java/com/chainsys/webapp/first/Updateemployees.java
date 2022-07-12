package com.chainsys.webapp.first;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.miniproject.commonutil.InValidInputDataException;
import com.chainsys.miniproject.commonutil.Validator;
import com.chainsys.miniproject.dao.EmployeeDao;
import com.chainsys.miniproject.pojo.Employee;

/**
 * Servlet implementation class Updateemployee
 */
public class Updateemployees extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Updateemployees() {
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
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
		System.out.println("Enter Employee first name:");
		String emp_Firstname=request.getParameter("fname");
		try {
			Validator.checkStringOnly(emp_Firstname);
		}catch(InValidInputDataException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		emp.setFirst_name(emp_Firstname);
		System.out.println("Enter Employee Last Name:");
		String emp_LastName=request.getParameter("lname");
		try {
			Validator.checkStringOnly(emp_LastName);
		}catch(InValidInputDataException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		emp.setLast_name(emp_LastName);
	    System.out.println("Enter Employee Email:");
	    String emp_email=request.getParameter("email");
	    try {
			Validator.checkEmail(emp_email);
		}catch(InValidInputDataException e) {
			e.printStackTrace();
			System.exit(-1);
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
			System.exit(-1);
		}
	    System.out.println("Enter the job_id:");
	    String emp_Job_id=request.getParameter("jobid");
	    try {
	    	Validator.checkJobId(emp_Job_id);
	    }catch(InValidInputDataException e) {
	    	e.printStackTrace();
	    	System.exit(-1);
	    }
	    emp.setJob_id(emp_Job_id);
	    System.out.println("Enter Salary of Employee:");
	    String emp_salary=request.getParameter("salary");
	    try {
	    	Validator.checkStringForParseInt(emp_salary);
	    }catch(InValidInputDataException e) {
	    	e.printStackTrace();
	    	System.exit(-1);
	    }
	    float salary=Float.parseFloat(emp_salary);
	    emp.setSalary(salary);
	    int result=EmployeeDao.updateEmployee(emp);
	    System.out.println(result+"row updated");
	   // sc.close();
	}
	
		

	

	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPut(request, response);
	}

}
