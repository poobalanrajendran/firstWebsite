package com.chainsys.miniproject.commonutil;

//import java.util.logging.LogManager;

public class ExceptionManager {
	public static String handleException(Exception e,String source,String message) {
		LogMannager.logException(e,source, message);
		message +="Message: "+e.getMessage();
		String errorPage=HTMLHelper.getHTMLTemplate("ERROR",message);
		return errorPage;
	}
}

