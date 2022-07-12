package com.chainsys.miniproject.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chainsys.miniproject.pojo.Doctor;
import com.chainsys.miniproject.pojo.Employee;

public class DoctorDao {
	/**
	 * getConnection() insertEmployee(Employee newemp) getEmployeeById(int id)
	 * getAllEmployee() updateEmployee(Employee newemp) deleteEmployee(int id)
	 * 
	 * @throws SQLException
	 */
	private static Connection getConnection() {
		String drivername = "oracle.jdbc.OracleDriver";
		String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "system";
		String password = "Rpoo5397";
		try {
			Class.forName(drivername);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection con = null;
		try {
			con = DriverManager.getConnection(dbUrl, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	private static java.sql.Date convertTosqlDate(java.util.Date date) {
		java.sql.Date sqldate = new java.sql.Date(date.getTime());
		return sqldate;

	}
public static int insertDoctor(Doctor doc)
{
	String insertquery="insert into Doctor( Doctor_id ,Doctor_Name ,dob ,Doctor_Speciality,Phone_no,City,Standard_fees)values(?,?,?,?,?,?,?)";
	Connection con=null;
	PreparedStatement ps=null;
	int row=0;
	try {
	con=getConnection();
	ps=con.prepareStatement(insertquery);
	ps.setInt(1, doc.getDoctor_id());
	ps.setString(2, doc.getDoctor_name());
	ps.setDate(3,convertTosqlDate(doc.getdate()));
	ps.setString(4, doc.getDoctor_speciality());
	ps.setLong(5, doc.getPhone_no());
	ps.setString(6,doc.getCity());
	ps.setFloat(7,doc.getStandard_fees());
	
	row = ps.executeUpdate();
}
catch (SQLException e) 
{
	e.printStackTrace();
} 
finally 
{
	try {
		ps.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	try {
		con.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
return row;
}
public static int updateDoctor(Doctor newemp) {
	String updatequery = "update Doctor set doctor_name=?,dob=?,doctor_speciality=?,phone_no=?,city=?,standard_fees=? where doctor_id=?";
	Connection con = null;
	int rows = 0;
	PreparedStatement ps = null;
	try {
		con = getConnection();
		ps = con.prepareStatement(updatequery);
		ps.setInt(7, newemp.getDoctor_id());
		ps.setString(1, newemp.getDoctor_name());
		ps.setDate(2, convertTosqlDate(newemp.getdate()));
		ps.setString(3, newemp.getDoctor_speciality());
		ps.setLong(4, newemp.getPhone_no());
		ps.setString(5, newemp.getCity());
		ps.setFloat(6, newemp.getStandard_fees());
		

		ps.executeUpdate();
		rows = ps.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		try {
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	return rows;
}

public static Doctor getDoctorById(int id) {
	Doctor emp =null;
	String selectquery = "select doctor_id,doctor_name,dob,doctor_speciality,phone_no,city,standard_fees from Doctor where doctor_id=? ";
	Connection con = null;
	PreparedStatement ps = null;
	 ResultSet rs  = null;
	try {
		con = getConnection();
		ps = con.prepareStatement(selectquery);
		ps.setInt(1, id);
		rs =ps.executeQuery();
		emp = new Doctor();
		   if(rs.next()) {
	          emp.setDoctor_id(rs.getInt(1));
	          emp.setDoctor_name(rs.getString(2));
	          //emp.setLast_name(rs.getString(3));
	          //emp.setEmail(rs.getString(4));
	          java.util.Date date = new java.util.Date(rs.getDate(3).getTime());//why getTime method used ok now clear 
	          //System.out.println("sqldate "+rs.getDate(5));
	         // System.out.println("sqltime "+rs.getDate(5).getTime());
	         // System.out.println("javadate "+date);
	          //date retrieved from the database will be of type java.sql.Date (rs.getDate(5))
	          //emp.setHire_date requires date of type java.util.Date 
	          //so we are converting sql Date to util Date 
	          //the constructor of java.util.Date requires a long value 
	          //so we use the getTime() which returns the sql date as a long value.
	          emp.setdate(date);//ok sir
	          emp.setDoctor_speciality(rs.getString(4));
	          emp.setPhone_no(rs.getInt(5));
	          emp.setCity(rs.getString(6));
	          emp.setStandard_fees(rs.getFloat(7));
	        }
	}catch(SQLException e) {
		e.printStackTrace();
	}finally {
		try {
			rs.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	return emp;

}

public static List<Doctor> getAllDoctor(){
	 List<Doctor> listOfEmployees = new ArrayList<Doctor>();//ok sir
	 Doctor emp =null;
		String selectquery ="select doctor_id,doctor_name,dob,doctor_speciality,phone_no,city,standard_fees from Doctor";
		Connection con = null;
		PreparedStatement ps = null;
		 ResultSet rs  = null;
		try {
			con = getConnection();
			ps = con.prepareStatement(selectquery);
			rs =ps.executeQuery();
			//emp = new Employee();
			   while(rs.next()) {
				   emp = new Doctor();
				   emp.setDoctor_id(rs.getInt(1));
			          emp.setDoctor_name(rs.getString(2));
			          //emp.setLast_name(rs.getString(3));
			          //emp.setEmail(rs.getString(4));
			          java.util.Date date = new java.util.Date(rs.getDate(3).getTime());//why getTime method used ok now clear 
			          emp.setdate(date);//ok sir
			          emp.setDoctor_speciality(rs.getString(4));
			          emp.setPhone_no(rs.getLong(5));
			          emp.setCity(rs.getString(6));
			          emp.setStandard_fees(rs.getFloat(7));
		          listOfEmployees.add(emp);
		        }
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	 return listOfEmployees;
}



public static int deleteDoctor(int id) {
	String deletequery = "delete doctor where doctor_id=?";
	Connection con = null;
	int rows = 0;
	PreparedStatement ps = null;

	try {
		con = getConnection();
		ps = con.prepareStatement(deletequery);
		ps.setInt(1, id);
		rows = ps.executeUpdate();	
	}catch(SQLException e) {
		e.printStackTrace();
	}finally {
		try {
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	return rows;
}

public static int updateDoctorName(int id,String docname) {
    String updatequery = "update doctor set doctor_name=? where doctor_id=?";
    Connection con = null;
    int rows = 0;
    PreparedStatement ps = null;
    try {
        con = getConnection();
        ps = con.prepareStatement(updatequery);
        ps.setString(1, docname);
        ps.setInt(2, id);
        ps.executeUpdate();
        rows = ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }finally {
        try {
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    return rows;

}

public static int updateStandardFees(int id, float fees) {
    String updatequery = "update doctor set Standard_fees=? where doctor_id=?";
    Connection con = null;
    int rows = 0;
    PreparedStatement ps = null;
    try {
        con = getConnection();
        ps = con.prepareStatement(updatequery);
        ps.setDouble(1, fees );
        ps.setInt(2, id);
        ps.executeUpdate();
        rows = ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }finally {
        try {
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    return rows;
}



}
