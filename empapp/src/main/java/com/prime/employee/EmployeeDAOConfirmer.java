package com.prime.employee;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployeeDAOConfirmer extends EmployeeDAO {

	static Logger log = Logger.getLogger(EmployeeDAOConfirmer.class.getName());
	
	@Autowired
	private EmployeeDAO employeeDAO;
	
	public EmployeeDAO getEmployeeDAO() {
		return employeeDAO;
	}

/*	############################################ for inserting data ############################################################ */	
	
	public boolean insertEmloyeeCon(EmployeeDTO edto) {
		
		log.info("insertEmployeeCon() is started");
		boolean bec = false;
		try {
			
			employeeDAO.insertEmployee(edto);
			bec = true;
			log.info("insertEmployeeCon() is endeded successfully");
			return bec;
		}
		catch(Exception e) {
			
			System.out.println("insertEmployeeCon() failled");
			return bec;
		}	
	}
	

/*	############################################ for retrieving data ############################################################ */

	public List<EmployeeVO> getAllEmployeesCon() {
		
		log.info("insertEmployeeCon() is executed");
		return employeeDAO.getAllEmployeesDAO();
	}
	
/* ######################################################## deleting data ################################################### */

	public boolean deleteEmployeeCon(EmployeeDTO employeeDTO) {

		boolean b = false;
		try {
			
			employeeDAO.deleteEmployeeDAO(employeeDTO);
			b = true;
		}
		catch(Exception e) {
			
			log.info("deleteEmployeeCon() failed to delete record"); 
		}
		
		return b;
	}
	
	
	
	
}
