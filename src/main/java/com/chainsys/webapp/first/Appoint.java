package com.chainsys.webapp.first;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.miniproject.commonutil.InValidInputDataException;
import com.chainsys.miniproject.commonutil.Validator;
import com.chainsys.miniproject.dao.AppointmentsDao;
import com.chainsys.miniproject.pojo.Appointments;

/**
 * Servlet implementation class Appoint
 */
public class Appoint extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Appoint() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		List<Appointments> applist =AppointmentsDao.getAllAppointments();
		Iterator<Appointments> appItr=applist.iterator();
		while(appItr.hasNext()) {
			Appointments app=appItr.next();
			out.println("<hr/>");
			out.println("app id:"+app.getAppointment_id()+","+"Appointment date:" + app.getAppointment_date()+","+"Doctor id:" + app.getDoctor_id()+","+"fees collected:" + app.getFees_collected()+","+"fees catagery:" + app.getFees_category()+"<p/>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
Appointments app = new Appointments();
	String submitvalue=request.getParameter("submit");	
		if(submitvalue.equals("insert")) {
		String app_id = request.getParameter("aid");
		try {
			Validator.checkStringForParseInt(app_id);
		}catch(InValidInputDataException e) {
			e.printStackTrace();
			System.exit(-1);
			
		}
		int id=Integer.parseInt(app_id);
		try {
			Validator.CheckNumberForGreaterThanZero(id);
		}catch(InValidInputDataException e) {
			e.printStackTrace();
			System.exit(-1);
		}

		app.setAppointment_id(id);
		
		System.out.println("Enter Appointment Date like \"dd/mm/yyyy\":");
		SimpleDateFormat appFormate = new SimpleDateFormat("dd/MM/yyyy");
		String app_date = request.getParameter("date");
		try {
			app.setAppointment_date(appFormate.parse(app_date));
		} catch (ParseException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		System.out.println("Enter Doctor id:");
		String doc_Id =request.getParameter("did");
		try {
			Validator.checkStringForParseInt(doc_Id);
		}catch(InValidInputDataException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		int doctor_id=Integer.parseInt(doc_Id);
		try {
			Validator.CheckNumberForGreaterThanZero(doctor_id);
		}catch(InValidInputDataException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		app.setDoctor_id(doctor_id);
		
		System.out.println("Enter patient Name:");
		String patient = request.getParameter("patientName");		
				try {
			Validator.checkStringOnly(patient);
		}catch(InValidInputDataException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		app.setPatient_name(patient);
		System.out.println("Enter fees collected:");
		String fees_collected = request.getParameter("fees");
		try {
			Validator.checkStringForParseInt(fees_collected);
		}catch(InValidInputDataException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		float fees=Integer.parseInt(fees_collected);
		
		try {
			Validator.CheckNumberForGreaterThanZero(fees);
		}catch(InValidInputDataException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		app.setFees_collected(fees);
		System.out.println("Enter fees catagery:");
		String fees_cat = request.getParameter("catagery");
		try {
			Validator.checkStringOnly(fees_cat);
		}catch(InValidInputDataException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		app.setFees_category(fees_cat);
		int result = AppointmentsDao.insertAppointments(app);
		out.println(result + "row inserted");
		}
		else if(submitvalue.equals("update"))
		{
		doPut(request,response);
	}
		else if(submitvalue.equals("delete"))
		{
		dodelete(request,response);
	}
	
	}
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out = response.getWriter();
		Appointments app = new Appointments();
				
				System.out.println("Enter the Appointment id:");
				String app_id = request.getParameter("aid");
				try {
					Validator.checkStringForParseInt(app_id);
				}catch(InValidInputDataException e) {
					e.printStackTrace();
					System.exit(-1);
					
				}
				int id=Integer.parseInt(app_id);
				try {
					Validator.CheckNumberForGreaterThanZero(id);
				}catch(InValidInputDataException e) {
					e.printStackTrace();
					System.exit(-1);
				}

				app.setAppointment_id(id);
				
				System.out.println("Enter Appointment Date like \"dd/mm/yyyy\":");
				SimpleDateFormat appFormate = new SimpleDateFormat("dd/MM/yyyy");
				String app_date = request.getParameter("date");
				try {
					app.setAppointment_date(appFormate.parse(app_date));
				} catch (ParseException e) {
					e.printStackTrace();
					System.exit(-1);
				}
				System.out.println("Enter Doctor id:");
				String doc_Id =request.getParameter("did");
				try {
					Validator.checkStringForParseInt(doc_Id);
				}catch(InValidInputDataException e) {
					e.printStackTrace();
					System.exit(-1);
				}
				int doctor_id=Integer.parseInt(doc_Id);
				try {
					Validator.CheckNumberForGreaterThanZero(doctor_id);
				}catch(InValidInputDataException e) {
					e.printStackTrace();
					System.exit(-1);
				}
				app.setDoctor_id(doctor_id);
				
				System.out.println("Enter patient Name:");
				String patient = request.getParameter("patientName");		
						try {
					Validator.checkStringOnly(patient);
				}catch(InValidInputDataException e) {
					e.printStackTrace();
					System.exit(-1);
				}
				app.setPatient_name(patient);
				System.out.println("Enter fees collected:");
				String fees_collected = request.getParameter("fees");
				try {
					Validator.checkStringForParseInt(fees_collected);
				}catch(InValidInputDataException e) {
					e.printStackTrace();
					System.exit(-1);
				}
				float fees=Integer.parseInt(fees_collected);
				
				try {
					Validator.CheckNumberForGreaterThanZero(fees);
				}catch(InValidInputDataException e) {
					e.printStackTrace();
					System.exit(-1);
				}
				app.setFees_collected(fees);
				System.out.println("Enter fees catagery:");
				String fees_cat = request.getParameter("catagery");
				try {
					Validator.checkStringOnly(fees_cat);
				}catch(InValidInputDataException e) {
					e.printStackTrace();
					System.exit(-1);
				}
				app.setFees_category(fees_cat);
				int result = AppointmentsDao.updateAppointments(app);
				out.println(result + "row updated");
				
			}
			
	
	protected void dodelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out = response.getWriter();
		Appointments app = new Appointments();
			//String submitvalue=request.getParameter("submit");	
				
				String app_id = request.getParameter("id");
				try {
					Validator.checkStringForParseInt(app_id);
				}catch(InValidInputDataException e) {
					e.printStackTrace();
					System.exit(-1);
					
				}
				int id=Integer.parseInt(app_id);
				try {
					Validator.CheckNumberForGreaterThanZero(id);
				}catch(InValidInputDataException e) {
					e.printStackTrace();
					System.exit(-1);
				}

				app.setAppointment_id(id);
				int result = AppointmentsDao.deleteAppointments(id);
				out.println(result + "row delete");
				
	
}

	}

