package com.chainsys.miniproject.businesslogic;

import java.util.Calendar;
import java.util.Date;

public class EmployeeController {
	 public static void logException(Exception ex, String source, String exMessage) {
	        Calendar vCalendar = Calendar.getInstance();
	        Date today = vCalendar.getTime();
	        if (source == null) {
	            source = "source not provided";
	        }
	        if (exMessage == null) {
	            exMessage = "custom message not provided";
	        }
	        String message = "Exception: " + today + " Message: " + ex.getMessage();
	        message += "\n Source: " + source + " custom message: " + exMessage;
	        String fileName="ExcpetionMessages"+today+".log";
	        writeToFile(fileName,message); 
	    }

	    public static void logException(Exception ex, String source) {
	        Calendar vCalendar = Calendar.getInstance();
	        Date today = vCalendar.getTime();
	        if (source == null) {
	            source = "source not provided";
	        }
	        String message = "Exception: " + today + " Message: " + ex.getMessage();
	        message += "\n Source: " + source;

	    }
	    private static void writeToFile(String fileName, String message ) {
	        
	    }
}
