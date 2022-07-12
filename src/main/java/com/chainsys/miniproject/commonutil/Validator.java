package com.chainsys.miniproject.commonutil;
import java.io.InvalidClassException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Validator {
	public static void checkStringForParseInt(String std_fees) throws InValidInputDataException{
		boolean result=false;
		String pattern="^[0-9]+$";
		Pattern patt=Pattern.compile(pattern);
		Matcher match = patt.matcher(std_fees);
		result=match.matches();
		if(!result) throw new InValidInputDataException("please enter Integer");
	}
	public static void CheckNumberForGreaterThanZero(int data) throws InValidInputDataException {
		if(data<0) {
			throw new InValidInputDataException("please enter number greater than zero");
		}
	
	}
	public static void checklengthOfString(String data) throws InValidInputDataException{
		
		int len=data.length();
		if(len<15 && len>3) ;
		else throw new InValidInputDataException("length does meet required length");
		
	}
	
	public static void checkStringOnly(String data) throws InValidInputDataException {
		boolean result=false;
		String pattern="^[a-zA-Z]+(\\\\s[a-zA-Z]+)?$";
		Pattern patt=Pattern.compile(pattern);
		Matcher match = patt.matcher(data);
		result=match.matches();
		if(!result) throw new InValidInputDataException("please enter character only");
	}
	
	
	public static void CheckNumberForGreaterThanZero(float data) throws InValidInputDataException {
		if(data<0) 
			throw new InValidInputDataException("please enter value greater than zero");
		
	}
	public static void checkEmail(String data) throws InValidInputDataException{
		boolean result=false;
	    String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" 
	        + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
	    Pattern patt=Pattern.compile(regexPattern);
		Matcher match = patt.matcher(data);
		result=match.matches();
	    if(!result) throw new InValidInputDataException("your email does not meet required length or complex");
	}
	public static void checkJobId(String data) throws InValidInputDataException{
		boolean result=false;
		String pattern="^[a-zA-Z0-9]([._-](?![._-])|[a-zA-Z0-9]){3,18}[a-zA-Z0-9]$";
		Pattern patt=Pattern.compile(pattern);
		Matcher match = patt.matcher(data);
		result=match.matches();
		if(!result) throw new InValidInputDataException("wrong pattern for job id");
	}
	public static void checkPhone(String data) throws InValidInputDataException{
		boolean result=false;
		String pattern="^[0-9]{10}$";
		Pattern patt=Pattern.compile(pattern);
		Matcher match = patt.matcher(data);
		result=match.matches();
		if(!result) throw new InValidInputDataException("please enter 10 digit ");
	}
	
	public static void checkSalaryLimit(float data) throws InValidInputDataException {
        if(data<7000 && data>150000) {
            throw new InValidInputDataException("please enter salary between 7000 and 150000");
        }
    }}
	   


