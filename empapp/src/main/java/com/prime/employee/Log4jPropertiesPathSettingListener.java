package com.prime.employee;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class Log4jPropertiesPathSettingListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent sce) {

	}

	public void contextInitialized(ServletContextEvent sce) {
		try {
	    	   
			ServletContext context = sce.getServletContext();
	    	String appPath = context.getRealPath("/WEB-INF/classes/log4j.properties");
	    	      
	    	FileInputStream in = new FileInputStream(appPath);
	    	Properties props = new Properties();
	    	props.load(in);
	    	in.close();
	    	
	    	if(!(props.getProperty("log4j.appender.Appender.File").equals(context.getRealPath("/logs/employee.log")))) {
	    	   
	    		FileOutputStream out = new FileOutputStream(appPath);
	    		props.setProperty("log4j.appender.Appender.File", context.getRealPath("/logs/employee.log"));
	    		props.store(out, null);
	    		out.close();
	    	}  
	    }
		catch (Exception e ) {
	            e.printStackTrace();
	    }	
	}
}
