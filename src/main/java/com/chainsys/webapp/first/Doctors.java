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
import com.chainsys.miniproject.dao.DoctorDao;
import com.chainsys.miniproject.dao.EmployeeDao;
import com.chainsys.miniproject.pojo.Doctor;

/**
 * Servlet implementation class Doctor
 */
public class Doctors extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Doctors() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		List<Doctor> doclist =DoctorDao.getAllDoctor();
		Iterator<Doctor> docItr=doclist.iterator();
		while(docItr.hasNext()) {
			Doctor doc=docItr.next();
		out.println("doc id:"+doc.getDoctor_id()+","+doc.getDoctor_name()+","+ doc.getdate()+","+doc.getDoctor_speciality()+","+doc.getPhone_no()+","+doc.getStandard_fees());
		}
		
			}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		Doctor doc = new Doctor();
		System.out.println("Enter the Doctor id:");
		String submitvalue=request.getParameter("submit");
		if(submitvalue.equals("addinsert"))
		{
		String doc_id = request.getParameter("did");
		try {
			Validator.checkStringForParseInt(doc_id);
		}catch(InValidInputDataException e) {
			e.printStackTrace();
			System.exit(-1);
			
		}
		int doctor_id=Integer.parseInt(doc_id);
		try {
			Validator.CheckNumberForGreaterThanZero(doctor_id);
		}catch(InValidInputDataException e) {
			e.printStackTrace();
			System.exit(-1);	
		}
		doc.setDoctor_id(doctor_id);
		System.out.println("Enter Doctor name:");
		String doc_name = request.getParameter("dname");
		try {
			Validator.checkStringOnly(doc_name);
		}catch(InValidInputDataException e) {
			e.printStackTrace();
			System.exit(-1);	
		}
		doc.setDoctor_name(doc_name);
		System.out.println("Enter Doctor Date of birth like \"dd/mm/yyyy\":");
		SimpleDateFormat dobFormate = new SimpleDateFormat("dd/MM/yyyy");
		String Dob = request.getParameter("ddate");
		try {
			doc.setdate(dobFormate.parse(Dob));
		} catch (ParseException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		System.out.println("Enter the Speciality:");
		String speciality = request.getParameter("dspecial");
		try {
			Validator.checkStringOnly(speciality);
		}catch(InValidInputDataException e) {
			e.printStackTrace();
			System.exit(-1);	
		}
		doc.setDoctor_speciality(speciality);
		System.out.println("Enter city:");
		String city =request.getParameter("location");
		try {
			Validator.checkStringOnly(city);
		}catch(InValidInputDataException e) {
			e.printStackTrace();
			System.exit(-1);	
		}
		doc.setCity(city);
		System.out.println("Enter phone number:");
		String phone =request.getParameter("phno");
		try {
			Validator.checkPhone(phone);
		}catch(InValidInputDataException e) {
			e.printStackTrace();
			System.exit(-1);	
		}
		doc.setPhone_no(Long.parseLong(phone));
		System.out.println("Enter Standard fees:");
		String std_fees = request.getParameter("fees");
		try {
			Validator.checkStringForParseInt(std_fees);
		}catch(InValidInputDataException e) {
			e.printStackTrace();
			System.exit(-1);	
		}
		float salary=Float.parseFloat(std_fees);
		doc.setStandard_fees(salary);
		int result = DoctorDao.insertDoctor(doc);
		out.println(result + "row inserted");
		
	}else if(submitvalue.equals("updateinsert"))
	{
		doPut( request,response);
	}
	else if(submitvalue.equals("delete"))
	//else if(request.getParameter("submit").equals("delete"))
	{
		doDelete(request,response);
	}
		}
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Doctor doc = new Doctor();
		System.out.println("Enter the Doctor id:");
		String doc_id = request.getParameter("did");
		try {
			Validator.checkStringForParseInt(doc_id);
		}catch(InValidInputDataException e) {
			e.printStackTrace();
			System.exit(-1);	
		}
		int doctor_id=Integer.parseInt(doc_id);
		try {
			Validator.CheckNumberForGreaterThanZero(doctor_id);
		}catch(InValidInputDataException e) {
			e.printStackTrace();
			System.exit(-1);	
		}
		doc.setDoctor_id(doctor_id);
		System.out.println("Enter Doctor name:");
		String doc_name = request.getParameter("dname");
		try {
			Validator.checkStringOnly(doc_name);
		}catch(InValidInputDataException e) {
			e.printStackTrace();
			System.exit(-1);	
		}
		doc.setDoctor_name(doc_name);
		System.out.println("Enter Doctor Date of birth like \"dd/mm/yyyy\":");
		SimpleDateFormat dobFormate = new SimpleDateFormat("dd/MM/yyyy");
		String Dob = request.getParameter("ddate");
		try {
			doc.setdate(dobFormate.parse(Dob));
		} catch (ParseException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		System.out.println("Enter the Speciality:");
		String speciality = request.getParameter("dspecial");
		try {
			Validator.checkStringOnly(speciality);
		}catch(InValidInputDataException e) {
			e.printStackTrace();
			System.exit(-1);	
		}
		doc.setDoctor_speciality(speciality);
		System.out.println("Enter city:");
		String city = request.getParameter("location");
		try {
			Validator.checkStringOnly(city);
		}catch(InValidInputDataException e) {
			e.printStackTrace();
			System.exit(-1);	
		}
		doc.setCity(city);
		System.out.println("Enter phone number:");
		String phone = request.getParameter("phno");
		try {
			Validator.checkPhone(phone);
		}catch(InValidInputDataException e) {
			e.printStackTrace();
			System.exit(-1);	
		}
		doc.setPhone_no(Long.parseLong(phone));
		String std_fees = request.getParameter("fees");
		try {
			Validator.checkStringForParseInt(std_fees);
		}catch(InValidInputDataException e) {
			e.printStackTrace();
			System.exit(-1);	
		}
		float salary=Float.parseFloat(std_fees);
		doc.setStandard_fees(salary);
		int result = DoctorDao.updateDoctor(doc);
		out.println(result + "row inserted");
	}
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		Doctor doc = new Doctor();
		String doc_id = request.getParameter("id");
		try {
			Validator.checkStringForParseInt(doc_id);
		}catch(InValidInputDataException e) {
			e.printStackTrace();
			System.exit(-1);	
		}
		int doctor_id=Integer.parseInt(doc_id);
		try {
			Validator.CheckNumberForGreaterThanZero(doctor_id);
		}catch(InValidInputDataException e) {
			e.printStackTrace();
			System.exit(-1);	
		}
		doc.setDoctor_id(doctor_id);
		int result = DoctorDao.deleteDoctor(doctor_id);
		out.println(result + "row Deleted");	
}}